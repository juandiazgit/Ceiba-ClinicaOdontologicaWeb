package com.ceiba.clinicaodontologica.dominio;

import com.ceiba.clinicaodontologica.dominio.validador.parametro.ValidarParametro;
import java.util.Date;

public class Cita {

	private static final String INGRESAR_PROCEDIMIENTO = "Se debe ingresar el procedimiento";
	private static final String INGRESAR_PROCEDIMIENTO_VALIDO = "Se debe ingresar un procedimiento valido";
	private static final String INGRESAR_FECHA_CITA = "Se debe ingresar una fecha para la cita";
	private static final String INGRESAR_PACIENTE = "Se debe ingresar el paciente";
	private static final String INGRESAR_DOCTOR = "Se debe ingresar el doctor";
	
	private String procedimiento;
	private Date fechaCita;
	private Paciente paciente;
	private Doctor doctor;
	private Factura factura;
	
	public Cita() {}
	
	public Cita(String procedimiento, Date fechaCita, Paciente paciente, Doctor doctor,
			    Factura factura) {
		ValidarParametro.validarObligatorio(procedimiento, INGRESAR_PROCEDIMIENTO);
		ValidarParametro.validarProcedimiento(procedimiento, INGRESAR_PROCEDIMIENTO_VALIDO);
		ValidarParametro.validarFecha(fechaCita, INGRESAR_FECHA_CITA);
		ValidarParametro.validarObjeto(paciente, INGRESAR_PACIENTE);
		ValidarParametro.validarObjeto(doctor, INGRESAR_DOCTOR);
		
		this.procedimiento = procedimiento;
		this.fechaCita = fechaCita;
		this.paciente = paciente;
		this.doctor = doctor;
		this.factura = factura;
	}
	
	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}
