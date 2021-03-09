package com.ceiba.clinicaodontologica.dominio.persistencia.repositorio;

import java.util.Date;
import java.util.List;

import com.ceiba.clinicaodontologica.dominio.Cita;

public interface RepositorioCita {

	Cita agregar(Cita cita);
    
	Cita obtenerCitaPorCodPaciente(int codioPaciente);    
    
    String actualizarCitaPorCodPaciente(int codioPaciente, Date fechaCita);
    
    List<Cita> obtenerListaCitas();
	
}
