package com.ceiba.clinicaodontologica.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoPaciente;
import com.ceiba.clinicaodontologica.dominio.Paciente;

@Component
public class FabricaPaciente {
	
    public Paciente crearPaciente(ComandoPaciente comandoPaciente) {
        
    	return new Paciente(comandoPaciente.getCodigo(),
    					comandoPaciente.getNombre(),
    					comandoPaciente.getApellido(),
    					comandoPaciente.getEdad(),
    					comandoPaciente.getTelefono());
    }
}
