package com.ceiba.clinicaodontologica.dominio;

import com.ceiba.clinicaodontologica.dominio.validador.parametro.ValidarParametro;

public class Paciente extends Persona{

	private static final String INGRESAR_CODIGO_PACIENTE = "Se debe ingresar el codigo del paciente";
	private static final String INGRESAR_NOMBRE_PACIENTE = "Se debe ingresar el nombre del paciente";
	private static final String INGRESAR_APELLIDO_PACIENTE = "Se debe ingresar el apellido del paciente";
	private static final String INGRESAR_EDAD_PACIENTE = "Se debe ingresar la edad del paciente";
	private static final String INGRESAR_TELEFONO_PACIENTE = "Se debe ingresar el telefono del paciente";
	
    private Integer edad;
    private String telefono;
	
    public Paciente() {}
    
    public Paciente(Integer codigo, String nombre, String apellido, Integer edad, String telefono) {
    	
    	super(codigo,nombre,apellido);
    	
    	ValidarParametro.validarObjeto(codigo, INGRESAR_CODIGO_PACIENTE);
    	ValidarParametro.validarObligatorio(nombre, INGRESAR_NOMBRE_PACIENTE);
    	ValidarParametro.validarObligatorio(apellido, INGRESAR_APELLIDO_PACIENTE);
    	ValidarParametro.validarObjeto(edad, INGRESAR_EDAD_PACIENTE);
    	ValidarParametro.validarObligatorio(telefono, INGRESAR_TELEFONO_PACIENTE);
    	
		this.edad = edad;
		this.telefono = telefono;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
