package com.ceiba.clinicaodontologica.dominio.servicio.cita;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.excepcion.CitaException;
import com.ceiba.clinicaodontologica.dominio.excepcion.PacienteException;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioObtenerPaciente;

@Service
public class ServicioCrearCita {

	private final RepositorioCita repositorioCita;
	private final ServicioObtenerPaciente servicioObtenerPaciente;
	
    private static final String NO_ASIGNACION_SABADO_DOMINGO = "Los sabados y domingos no se pueden asignar citas";
    private static final String NO_ASIGNACION_CITA_MISMA_FECHA = "Ya se encuentra agendad una cita para el dcotor en la misma fecha y hora";

    public ServicioCrearCita(RepositorioCita repositorioCita, ServicioObtenerPaciente servicioObtenerPaciente) {
        this.repositorioCita = repositorioCita;
        this.servicioObtenerPaciente = servicioObtenerPaciente;
    }

    public Cita ejecutar(Cita cita) {
    	
    	Calendar calendario = Calendar.getInstance();
    	calendario.setTime(cita.getFechaCita());
    	
    	if(esSabadoDomingo(calendario)) {
    		throw new CitaException(NO_ASIGNACION_SABADO_DOMINGO);
    	}
    	
    	cita.setFechaCita(obtenerSiguienteDiaHabil(calendario));
    	cita.setFactura(null);
    	
    	if (!sePuedeAgendarADoctor(cita)) {
    		throw new CitaException(NO_ASIGNACION_CITA_MISMA_FECHA);
		}
    	
    	existePaciente(cita.getPaciente().getCodigo());
    	
        return this.repositorioCita.agregar(cita);
    }
    
    private Date obtenerSiguienteDiaHabil(Calendar calendario) {
		
	    boolean diaSigHabil = false;
	    int diaSumado = 1;
	      
	    while (!diaSigHabil) {
	          
	    	calendario.add(Calendar.DAY_OF_YEAR, diaSumado);
	          
	        if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
	        	calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	        	continue;
	        }else{
	        	diaSigHabil = true;
	        }
	    }
	    
	    return calendario.getTime();
	}
	
	private boolean esSabadoDomingo(Calendar calendario) {

		if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
		    calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			return true;
		}
		return false;
	}
	
	private boolean sePuedeAgendarADoctor(Cita cita) {
		
		List<Cita> listaCitas = repositorioCita.obtenerListaCitas();
		
		for (Cita ct : listaCitas) {
			
			String fechaCita = new Timestamp(cita.getFechaCita().getTime()).toString();
			String fechaCitaLista = ct.getFechaCita().toString();
			
			if (ct.getDoctor().getCodigo().equals(cita.getDoctor().getCodigo()) && 
				fechaCitaLista.equalsIgnoreCase(fechaCita)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean existePaciente(int codPaciente){
		
		servicioObtenerPaciente.ejecutar(codPaciente);
		return true; 
	}
}
