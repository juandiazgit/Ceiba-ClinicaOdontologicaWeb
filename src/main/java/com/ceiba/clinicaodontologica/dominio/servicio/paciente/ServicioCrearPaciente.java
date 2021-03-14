package com.ceiba.clinicaodontologica.dominio.servicio.paciente;

import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.excepcion.PacienteException;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioPaciente;

@Service
public class ServicioCrearPaciente {

	public static final String PACIENTE_CODIGO_ENCONTRADO = "Ya se encuentra registrado un paciente con el codigo indicado.";
	private final RepositorioPaciente repositorioPaciente;
	
    public ServicioCrearPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public Paciente ejecutar(Paciente paciente) {
    	
    	if (repositorioPaciente.obtenerByCodigo(paciente.getCodigo()) !=  null) {
			throw new PacienteException(PACIENTE_CODIGO_ENCONTRADO);
		}
    	
    	return repositorioPaciente.agregar(paciente);
    }
	
}
