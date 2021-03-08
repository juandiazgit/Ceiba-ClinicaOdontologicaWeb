package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio;

import java.util.List;

import com.ceiba.clinicaodontologica.dominio.Paciente;

public interface RepositorioPaciente {

    Paciente obtener(Long id);

    List<Paciente> listaPaciente();
	
}
