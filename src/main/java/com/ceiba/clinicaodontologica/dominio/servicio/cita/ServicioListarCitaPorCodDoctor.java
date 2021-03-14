package com.ceiba.clinicaodontologica.dominio.servicio.cita;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.excepcion.CitaException;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioCita;

@Service
public class ServicioListarCitaPorCodDoctor {

	private static final String EL_DOCTOR_NO_TIENE_CITA = "El doctor no tiene cita asignada";
	private final RepositorioCita repositorioCita;

    public ServicioListarCitaPorCodDoctor(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public List<Cita> ejecutar(int codigoDoctor) {
    	
		List<Cita> listaCitasResult = repositorioCita.obtenerListaCitas();
		List<Cita> listaCitas = new ArrayList<>();
		
		for (Cita cita : listaCitasResult) {
        	if (cita.getDoctor().getCodigo() == codigoDoctor) {
        		listaCitas.add(cita);
			}
		}
		
		if (listaCitas.isEmpty()) {
			throw new CitaException(EL_DOCTOR_NO_TIENE_CITA);
		}
                
        return listaCitas;
        
    }
	
}
