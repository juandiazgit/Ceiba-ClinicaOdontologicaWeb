package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.repository.CrudRepository;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.CitaEntity;

public interface RepositorioCitaJPA extends CrudRepository<CitaEntity, Long> {
	
}
