package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.CitaEntity;

public interface RepositorioCitaJPA extends CrudRepository<CitaEntity, Long> {
	
//	@Query("Sentence")
//	List<CitaEntity> findByCodDoctor(String name);
}
