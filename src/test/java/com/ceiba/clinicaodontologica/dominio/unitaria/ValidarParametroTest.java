package com.ceiba.clinicaodontologica.dominio.unitaria;

import java.util.Date;

import org.junit.Test;

import com.ceiba.clinicaodontologica.dominio.excepcion.CitaException;
import com.ceiba.clinicaodontologica.dominio.validador.parametro.ValidarParametro;

public class ValidarParametroTest {

	
	@Test(expected = CitaException.class)
	public void validarObligatorioCampoNullTest() {
		
		 ValidarParametro.validarObligatorio(null,"Mensaje");
		
	}
	
	@Test(expected = CitaException.class)
	public void validarObligatorioCampoVacioTest() {
		
		final String PROCEDIMIENTO = "";
		
		ValidarParametro.validarObligatorio(PROCEDIMIENTO,"Mensaje");
		
	}
	
	@Test(expected = CitaException.class)
	public void validarObligatorioFechaNullTest() {
		
		Date fecha = null;
		
		ValidarParametro.validarFecha(fecha,"Mensaje");
		
	}
	
	@Test(expected = CitaException.class)
	public void validarObligatorioObjetoNullTest() {
		
		Object obj = null;
		
		ValidarParametro.validarObjeto(obj,"Mensaje");
		
	}
	
	@Test(expected = CitaException.class)
	public void validarObligatorioValorMenorCeroTest() {
		
		double valor = -1;
		
		ValidarParametro.validarValor(valor,"Mensaje");
		
	}
	
	@Test
	public void validarObligatorioValorMayorCeroTest() {
		
		double valor = 1;
		
		ValidarParametro.validarValor(valor,"Mensaje");
		
	}
	
	@Test
	public void validarProcedimientoEndodonciaTest() {
		
		final String PROCEDIMIENTO = "ENDODONCIA";
		
		ValidarParametro.validarProcedimiento(PROCEDIMIENTO,"Mensaje");
		
	}
	
	@Test
	public void validarProcedimientoControlTest() {
		
		final String PROCEDIMIENTO = "CONTROL";
		
		ValidarParametro.validarProcedimiento(PROCEDIMIENTO,"Mensaje");
		
	}
	
	@Test(expected = CitaException.class)
	public void validarProcedimientoExceptionTest() {
		
		final String PROCEDIMIENTO = "NINGUNO";
		
		ValidarParametro.validarProcedimiento(PROCEDIMIENTO,"Mensaje");
		
	}
}
