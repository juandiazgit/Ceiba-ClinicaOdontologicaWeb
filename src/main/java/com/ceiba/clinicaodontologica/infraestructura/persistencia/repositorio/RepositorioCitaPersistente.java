package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.builder.CitaBuilder;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.CitaEntity;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.jpa.RepositorioCitaJPA;

@Repository
public class RepositorioCitaPersistente implements RepositorioCita {
	
	private final RepositorioCitaJPA repositorioCitaJPA;
	
	public RepositorioCitaPersistente(RepositorioCitaJPA repositorioCitaJPA) {
		this.repositorioCitaJPA = repositorioCitaJPA;
	}
	
	@Override
	@Transactional
	public Cita agregar(Cita cita) {
        CitaEntity citaPersistida = repositorioCitaJPA.save(CitaBuilder.convertirAEntity(cita));
        return CitaBuilder.convertirADominio(citaPersistida);
	}
	
	@Override
	public String actualizarCitaPorCodPaciente(int codioPaciente, Date fechaCita) {
		return null;
	}

	@Override
	public List<Cita> obtenerListaCitas() {
		
		List<Cita> listaCitas = new ArrayList<>();
        
		repositorioCitaJPA.findAll().forEach(citaEntity ->
		listaCitas.add(CitaBuilder.convertirADominio(citaEntity)));
                
        return listaCitas;
	}
	
}
