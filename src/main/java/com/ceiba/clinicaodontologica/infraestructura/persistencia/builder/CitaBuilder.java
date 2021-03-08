package com.ceiba.clinicaodontologica.infraestructura.persistencia.builder;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Doctor;
import com.ceiba.clinicaodontologica.dominio.Factura;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.CitaEntity;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.DoctorEntity;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.FacturaEntity;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.PacienteEntity;

public final class CitaBuilder{

	private CitaBuilder() {
	}

	public static Cita convertirADominio(CitaEntity citaEntity) {
		
		Cita cita = null;
		Factura factura = null;
		
		if (citaEntity.getFactura() != null) {
			factura = new Factura(citaEntity.getFactura().getFechaGeneracion(),
				citaEntity.getFactura().getValorPagar());
		}
		
		if (citaEntity != null) {
			cita = new Cita(citaEntity.getProcedimiento(),
							citaEntity.getFechaCita(), 
							PacienteBuilder.convertirADominio(citaEntity.getPaciente()),
							DoctorBuilder.convertirADominio(citaEntity.getDoctor()), 
							factura);
		}
		return cita;
	}

	public static CitaEntity convertirAEntity(Cita cita) {
		
		CitaEntity citaEntity = new CitaEntity();
		FacturaEntity facturaEntity = null;
		
		if (cita.getFactura() != null) {
			facturaEntity = new FacturaEntity(cita.getFactura().getFechaGeneracion(),
					  cita.getFactura().getValorPagar());
		}
		
		citaEntity.setProcedimiento(cita.getProcedimiento());
		citaEntity.setFechaCita(cita.getFechaCita());
		citaEntity.setPaciente(PacienteBuilder.convertirAEntity(cita.getPaciente()));
		citaEntity.setDoctor(DoctorBuilder.convertirAEntity(cita.getDoctor()));
		citaEntity.setFactura(facturaEntity);
		return citaEntity;
	}
}
