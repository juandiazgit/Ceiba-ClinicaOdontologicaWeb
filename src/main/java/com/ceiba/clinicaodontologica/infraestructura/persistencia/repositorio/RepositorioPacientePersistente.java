package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioPaciente;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.builder.PacienteBuilder;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.PacienteEntity;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.jpa.RepositorioPacienteJPA;

@Repository
public class RepositorioPacientePersistente implements RepositorioPaciente {

	private final RepositorioPacienteJPA repositorioPacienteJPA;
	
	public RepositorioPacientePersistente(RepositorioPacienteJPA repositorioPacienteJPA) {
		this.repositorioPacienteJPA = repositorioPacienteJPA;
	}
	
	@Override
	public Paciente obtener(Long id) {
        PacienteEntity pacienteEntity = repositorioPacienteJPA.findById(id).orElse(null);
        return PacienteBuilder.convertirADominio(pacienteEntity);
	}

	@Override
	public List<Paciente> listaPaciente() {
        List<Paciente> listaPacientes = new ArrayList<>();
        repositorioPacienteJPA.findAll().forEach(pacienteEntity ->
        listaPacientes.add(PacienteBuilder.convertirADominio(pacienteEntity)));
        return listaPacientes;
	}
	
}
