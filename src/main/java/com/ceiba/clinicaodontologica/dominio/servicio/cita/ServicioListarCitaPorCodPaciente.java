package com.ceiba.clinicaodontologica.dominio.servicio.cita;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.excepcion.CitaException;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioPaciente;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.builder.CitaBuilder;

@Service
public class ServicioListarCitaPorCodPaciente {

	private static final String EL_PACIENTE_NO_TIENE_CITA = "El paciente no tiene cita asignada";
	private final RepositorioCita repositorioCita;

    public ServicioListarCitaPorCodPaciente(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public List<Cita> ejecutar(int codPaciente) {
    	
		List<Cita> listaCitasResult = repositorioCita.obtenerListaCitas();
		List<Cita> listaCitas = new ArrayList<>();
		
		for (Cita cita : listaCitasResult) {
        	if (cita.getPaciente().getCodigo() == codPaciente) {
        		listaCitas.add(cita);
			}
		}
		
		if (listaCitas.size() == 0) {
			throw new CitaException(EL_PACIENTE_NO_TIENE_CITA);
		}
                
        return listaCitas;
        
    }
	
}
