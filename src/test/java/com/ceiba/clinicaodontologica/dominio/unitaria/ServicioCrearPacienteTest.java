
package com.ceiba.clinicaodontologica.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioPaciente;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioCrearPaciente;
import com.ceiba.clinicaodontologica.testdatabuilder.PacienteTestDataBuilder;

public class ServicioCrearPacienteTest {
    
    @Test
    public void ejecutarRegistrarPacienteTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    	//Arrange      	
    	RepositorioPaciente repositorioPaciente = mock(RepositorioPaciente.class);
   	 	ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
   	 	
   	 	Paciente paciente1 = new PacienteTestDataBuilder().build();
   	 	
   	 	//Act
   	 	when(repositorioPaciente.agregar(paciente1)).thenReturn(paciente1);
   	 	Paciente paciente2 = servicioCrearPaciente.ejecutar(paciente1);
   	 	
        //Assert
        assertEquals(paciente1, paciente2); 
    }


}

