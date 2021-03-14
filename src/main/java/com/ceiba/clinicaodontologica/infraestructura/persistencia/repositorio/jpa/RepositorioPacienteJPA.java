package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.PacienteEntity;

@Repository
public interface RepositorioPacienteJPA extends CrudRepository<PacienteEntity, Long> {
	
	@Query("select p from Paciente p where p.codigo = :codigo")
	PacienteEntity findByCodigo(@Param("codigo") int codigo);
	
}
