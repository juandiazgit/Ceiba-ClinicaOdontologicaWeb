package com.ceiba.clinicaodontologica.dominio.excepcion;

public class CitaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CitaException(String message) {
        super(message);
    }
}
