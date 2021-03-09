package com.ceiba.clinicaodontologica.dominio;

import com.ceiba.clinicaodontologica.dominio.validador.parametro.ValidarParametro;

public class Doctor {

	private static final String INGRESAR_CODIGO_DOCTOR = "Se debe ingresar el codigo del doctor";
	private static final String INGRESAR_NOMBRE_DOCTOR = "Se debe ingresar el nombre del doctor";
	private static final String INGRESAR_APELLIDO_DOCTOR = "Se debe ingresar el apellido del doctor";
	private static final String INGRESAR_ESPECIALIZACION_DOCTOR = "Se debe ingresar la especializacion del doctor";
	
    private Integer codigo;
    private String nombre;
    private String apellido;
    private String especializacion;
    
	public Doctor() {}
    
    public Doctor(Integer codigo, String nombre, String apellido, String especializacion) {
    	
    	ValidarParametro.validarObjeto(codigo, INGRESAR_CODIGO_DOCTOR);
    	ValidarParametro.validarObligatorio(nombre, INGRESAR_NOMBRE_DOCTOR);
    	ValidarParametro.validarObligatorio(apellido, INGRESAR_APELLIDO_DOCTOR);
    	ValidarParametro.validarObligatorio(especializacion, INGRESAR_ESPECIALIZACION_DOCTOR);
    	
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especializacion = especializacion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	    
}
