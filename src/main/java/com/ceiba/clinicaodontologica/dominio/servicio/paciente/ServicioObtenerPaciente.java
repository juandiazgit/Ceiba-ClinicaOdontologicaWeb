package com.ceiba.clinicaodontologica.dominio.servicio.paciente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.excepcion.PacienteException;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioPaciente;

@Service
public class ServicioObtenerPaciente {

    public static final String 	PACIENTE_NO_ENCONTRADA = "El paciente no se encuentra registrado.";

    private final RepositorioPaciente repositorioPaciente;

    public ServicioObtenerPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public Paciente ejecutar(int codPaciente) {
    	
    	List<Paciente> listaPacienteResult = this.repositorioPaciente.listaPaciente();
		List<Paciente> listaPacientes = new ArrayList<>();
		
		for (Paciente paciente : listaPacienteResult) {
        	if (paciente.getCodigo() == codPaciente) {
        		listaPacientes.add(paciente);
			}
		}
		
		if (listaPacientes.size() == 0) {
			throw new PacienteException(PACIENTE_NO_ENCONTRADA);
		}
                
        return listaPacientes.get(0);
    }
	
}
