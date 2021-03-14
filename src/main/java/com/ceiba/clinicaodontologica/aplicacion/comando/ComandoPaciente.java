package com.ceiba.clinicaodontologica.aplicacion.comando;

import com.ceiba.clinicaodontologica.dominio.Paciente;

public class ComandoPaciente extends Paciente{
	
	public ComandoPaciente() {
		super();
	}
	
	public ComandoPaciente(Integer codigo, String nombre, String apellido, Integer edad, String telefono) {
		super(codigo,nombre,apellido,edad,telefono);
	}

}
