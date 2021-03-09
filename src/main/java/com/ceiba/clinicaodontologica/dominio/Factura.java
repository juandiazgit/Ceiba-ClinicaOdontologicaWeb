package com.ceiba.clinicaodontologica.dominio;

import java.util.Date;

import com.ceiba.clinicaodontologica.dominio.validador.parametro.ValidarParametro;

public class Factura {

	private static final String INGRESAR_FECHA_GENERACION = "Se debe asignar una fecha de generacion para la factura";
	private static final String INGRESAR_VALOR_PAGAR = "El valor a pagar en la factura debe ser mayor a cero";
	
    private Date fechaGeneracion;
    private double valorPagar;
	
    public Factura(Date fechaGeneracion, double valorPagar) {
    	
    	ValidarParametro.validarFecha(fechaGeneracion, INGRESAR_FECHA_GENERACION);
    	ValidarParametro.validarValor(valorPagar, INGRESAR_VALOR_PAGAR);
    	
		this.fechaGeneracion = fechaGeneracion;
		this.valorPagar = valorPagar;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}
    
}
