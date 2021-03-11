package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.PacienteEntity;

@Repository
public interface RepositorioPacienteJPA extends CrudRepository<PacienteEntity, Long> {
	
}
