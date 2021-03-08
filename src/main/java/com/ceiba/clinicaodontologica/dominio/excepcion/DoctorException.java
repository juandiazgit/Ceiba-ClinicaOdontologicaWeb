package com.ceiba.clinicaodontologica.dominio.excepcion;

public class DoctorException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DoctorException(String message) {
        super(message);
    }
    
}
