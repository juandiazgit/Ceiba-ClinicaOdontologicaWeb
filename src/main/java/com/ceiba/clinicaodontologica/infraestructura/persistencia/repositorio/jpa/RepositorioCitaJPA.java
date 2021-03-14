package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.CitaEntity;

@Repository
public interface RepositorioCitaJPA extends CrudRepository<CitaEntity, Long> {
	
//	@Query("Sentence")
//	List<CitaEntity> findByCodDoctor(String name);
	
}
