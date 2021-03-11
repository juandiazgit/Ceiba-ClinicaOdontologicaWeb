package com.ceiba.clinicaodontologica.dominio.validador.parametro;

import java.util.Date;

import com.ceiba.clinicaodontologica.dominio.excepcion.CitaException;

public class ValidarParametro {

	enum PROCEDIMIENTO {
		LIMPIEZA, CONTROL, ORTODONCIA, ENDODONCIA
	}

	public static void validarObligatorio(String campo, String mensajeException) {
		if (campo == null || campo.trim().length() == 0)
			throw new CitaException(mensajeException);
	}

	public static void validarFecha(Date fecha, String mensajeException) {
		if (fecha == null) {
			throw new CitaException(mensajeException);
		}
	}

	public static void validarProcedimiento(String procedimiento, String mensajeException) {
		
		try {
			procedimiento.toUpperCase();

			if (PROCEDIMIENTO.valueOf(procedimiento).equals(PROCEDIMIENTO.LIMPIEZA)
					|| PROCEDIMIENTO.valueOf(procedimiento).equals(PROCEDIMIENTO.CONTROL)
					|| PROCEDIMIENTO.valueOf(procedimiento).equals(PROCEDIMIENTO.ORTODONCIA)
					|| PROCEDIMIENTO.valueOf(procedimiento).equals(PROCEDIMIENTO.ENDODONCIA)) {
				return;
			}
		} catch (Exception e) {
			throw new CitaException(mensajeException);
		}
	}
	
	public static void validarObjeto(Object objeto, String mensajeException) {
		if (objeto == null) {
			throw new CitaException(mensajeException);
		}
	}
	
	public static void validarValor(double valor, String mensajeException) {
		if (valor <= 0 ) {
			throw new CitaException(mensajeException);
		}
	}

}