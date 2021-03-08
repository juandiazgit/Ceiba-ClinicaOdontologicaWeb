package com.ceiba.clinicaodontologica.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioCrearCita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioListarCitaPorCodDoctor;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioObtenerPaciente;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;

public class ServicioListarCitaPorCodDoctorTest {

    @Test
    public void ejecutarListarCitaPorCodDoctorTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    	//Arrange      	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioListarCitaPorCodDoctor servicioListarCitaPorCodDoctor = new ServicioListarCitaPorCodDoctor(repositorioCita);
   	 	List<Cita> listaCita = new ArrayList<Cita>();
   	 	List<Cita> listaCitaResult = new ArrayList<Cita>();
   	 	Cita cita = new CitaTestDataBuilder().build();
   	 	int codDoctor = cita.getDoctor().getCodigo();
   	 	listaCita.add(cita);
   	 	
   	 	//Act
   	 	when(repositorioCita.obtenerListaCitas()).thenReturn(listaCita);
   	 	listaCitaResult = servicioListarCitaPorCodDoctor.ejecutar(codDoctor);
  	 	
        //Assert
        assertEquals(listaCita, listaCitaResult); 
    }
	
}
