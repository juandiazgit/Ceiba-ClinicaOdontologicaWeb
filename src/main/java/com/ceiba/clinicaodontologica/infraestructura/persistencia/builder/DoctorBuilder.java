package com.ceiba.clinicaodontologica.infraestructura.persistencia.builder;

import com.ceiba.clinicaodontologica.dominio.Doctor;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.DoctorEntity;

public final class DoctorBuilder{

	private DoctorBuilder() {
	}

	public static Doctor convertirADominio(DoctorEntity doctorEntity) {
		Doctor doctor = null;
		if (doctorEntity != null) {
			doctor = new Doctor(doctorEntity.getCodigo(),
								doctorEntity.getNombre(),
								doctorEntity.getApellido(), 
								doctorEntity.getEspecializacion());
		}
		return doctor;
	}

	public static DoctorEntity convertirAEntity(Doctor doctor) {
		DoctorEntity doctorEntity = new DoctorEntity();
		doctorEntity.setCodigo(doctor.getCodigo());
		doctorEntity.setNombre(doctor.getNombre());
		doctorEntity.setApellido(doctor.getApellido());
		doctorEntity.setEspecializacion(doctor.getEspecializacion());
		return doctorEntity;
	}
}
