package com.ceiba.clinicaodontologica.dominio;

import com.ceiba.clinicaodontologica.dominio.validador.parametro.ValidarParametro;

public class Doctor extends Persona{

	private static final String INGRESAR_CODIGO_DOCTOR = "Se debe ingresar el codigo del doctor";
	private static final String INGRESAR_NOMBRE_DOCTOR = "Se debe ingresar el nombre del doctor";
	private static final String INGRESAR_APELLIDO_DOCTOR = "Se debe ingresar el apellido del doctor";
	private static final String INGRESAR_ESPECIALIZACION_DOCTOR = "Se debe ingresar la especializacion del doctor";
	
    private String especializacion;
    
	public Doctor() {}
    
    public Doctor(Integer codigo, String nombre, String apellido, String especializacion) {
    	
    	super(codigo, nombre, apellido);
    	
		ValidarParametro.validarObjeto(codigo, INGRESAR_CODIGO_DOCTOR);
    	ValidarParametro.validarObligatorio(nombre, INGRESAR_NOMBRE_DOCTOR);
    	ValidarParametro.validarObligatorio(apellido, INGRESAR_APELLIDO_DOCTOR);
    	ValidarParametro.validarObligatorio(especializacion, INGRESAR_ESPECIALIZACION_DOCTOR);
    	
    	this.especializacion = especializacion;
		
	}

	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	    
}
