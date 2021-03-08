package com.ceiba.clinicaodontologica.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioListarCitaPorCodDoctor;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioListarCitaPorCodPaciente;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;

public class ServicioListarCitaPorCodPacienteTest {
    
	@Test
    public void ejecutarListarCitaPorCodPacienteTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    	//Arrange      	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioListarCitaPorCodPaciente servicioListarCitaPorCodPaciente = new ServicioListarCitaPorCodPaciente(repositorioCita);
   	 	List<Cita> listaCita = new ArrayList<Cita>();
   	 	List<Cita> listaCitaResult = new ArrayList<Cita>();
   	 	Cita cita = new CitaTestDataBuilder().build();
   	 	int codPaciente = cita.getPaciente().getCodigo();
   	 	listaCita.add(cita);
   	 	
   	 	//Act
   	 	when(repositorioCita.obtenerListaCitas()).thenReturn(listaCita);
   	 	listaCitaResult = servicioListarCitaPorCodPaciente.ejecutar(codPaciente);
  	 	
        //Assert
        assertEquals(listaCita, listaCitaResult); 
    }
}
