package com.ceiba.clinicaodontologica.dominio.persistencia.repositorio;

import java.util.List;

import com.ceiba.clinicaodontologica.dominio.Paciente;

public interface RepositorioPaciente {

	Paciente agregar(Paciente paciente);
	
	Paciente obtener(Long id);

    List<Paciente> listaPaciente();
	
    Paciente obtenerByCodigo(int codigo);
}
