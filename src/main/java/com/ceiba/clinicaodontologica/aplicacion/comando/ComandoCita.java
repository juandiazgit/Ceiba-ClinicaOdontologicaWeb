package com.ceiba.clinicaodontologica.aplicacion.comando;

import java.util.Date;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Doctor;
import com.ceiba.clinicaodontologica.dominio.Factura;
import com.ceiba.clinicaodontologica.dominio.Paciente;

public class ComandoCita extends Cita{
	
	public ComandoCita(String procedimiento, Date fechaCita, Paciente paciente, Doctor doctor,
			Factura factura) {
		super(procedimiento,fechaCita,paciente,doctor,factura);
	}

}
