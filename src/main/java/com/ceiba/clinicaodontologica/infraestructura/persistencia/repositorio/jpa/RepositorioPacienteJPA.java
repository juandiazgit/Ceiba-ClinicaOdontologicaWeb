package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.repository.CrudRepository;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.PacienteEntity;

public interface RepositorioPacienteJPA extends CrudRepository<PacienteEntity, Long> {
	
}
