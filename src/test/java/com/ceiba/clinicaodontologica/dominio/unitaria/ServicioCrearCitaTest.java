
package com.ceiba.clinicaodontologica.dominio.unitaria;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.excepcion.PacienteException;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioCrearCita;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioObtenerPaciente;
//import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioPrestamo;
//import com.ceiba.clinicaodontologica.dominio.servicio.bibliotecario.ServicioBibliotecario;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.clinicaodontologica.testdatabuilder.PacienteTestDataBuilder;
import com.ceiba.clinicaodontologica.dominio.Cita;
//import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;

import org.junit.Test;
import org.mockito.internal.verification.Times;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.AssertFalse;

public class ServicioCrearCitaTest {
    
//    @Test
//    public void esSiguienteDiaHabilTest() {
//        // arrange
//         String PROCEDIMIENTO = "Ortodoncia";
//         Date FECHACITA = new Date();
//    	 RepositorioCita repositorioCita = mock(RepositorioCita.class);
//    	 ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
//    	 ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
//         /*Calendar calendario = Calendar.getInstance();
//         calendario.add(Calendar.DAY_OF_YEAR, 1);
//         Date sigDiaHabil = calendario.getTime();*/
//
//         CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().
//        		 								   conProcedimiento(PROCEDIMIENTO).
//        		 								   conFechaCita(FECHACITA);
//         
//         Cita cita = new CitaTestDataBuilder().build();
//
//         // act
//         servicioCrearCita.ejecutar(cita);
//
//        // Asset
//         //verify(servicioCrearCita.esSabadoDomingo())
//         verify(servicioCrearCita.esSabadoDomingo(), times(1));
//        //assertEquals(sigDiaHabil, sigDiaHabilAct);
//    }
    
	@Test
    public void esSabadoDomingo() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
    	//Arrange
    	Calendar calendario = Calendar.getInstance();
    	calendario.setTime(new Date(2021-1900, 2, 6, 10, 30, 10));
    	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
   	 	ServicioCrearCita instancia = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
   	 	
        //Act 
        Method metodoPrivado = instancia.getClass().getDeclaredMethod("esSabadoDomingo", new Class[]{Calendar.class});  
        metodoPrivado.setAccessible(true);
 
        boolean resultado = (boolean)metodoPrivado.invoke(instancia, new Object[]{calendario});

        //Assert
        assertTrue(resultado);  
    }
    
    @Test
    public void noEsSabadoDomingo() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //Arrange
    	Calendar calendario = Calendar.getInstance();
    	calendario.setTime(new Date(2021-1900, 2, 10, 12, 30, 12));
    	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
   	 	ServicioCrearCita instancia = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
   	 	
   	 	//Act
        Method metodoPrivado = instancia.getClass().getDeclaredMethod("esSabadoDomingo", new Class[]{Calendar.class});  
        metodoPrivado.setAccessible(true);
        boolean resultado = (boolean)metodoPrivado.invoke(instancia, new Object[]{calendario});

        //Assert
        assertFalse(resultado);  
    }
   
    @Test
    public void dadoUnDiaHabilRetornarSiguienteDiaHabil() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //Arrange
    	Calendar calendario = Calendar.getInstance();
    	calendario.setTime(new Date(2021-1900, 2, 9, 12, 30, 12));
    	Date fechaEsperada = new Date(2021-1900, 2, 10, 12, 30, 12);
    	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
   	 	ServicioCrearCita instancia = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
   	 	
        //Act 
        Method metodoPrivado = instancia.getClass().getDeclaredMethod("obtenerSiguienteDiaHabil", new Class[]{Calendar.class});  
        metodoPrivado.setAccessible(true);
        Date resultado = (Date)metodoPrivado.invoke(instancia, new Object[]{calendario});

        //Assert
        assertEquals(fechaEsperada,resultado);  
    }
    
    @Test
    public void dadoUnNoDiaHabilRetornarSiguienteDiaHabil() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //Arrange
    	Calendar calendario = Calendar.getInstance();
    	calendario.setTime(new Date(2021-1900, 2, 6, 12, 30, 12));
    	Date fechaEsperada = new Date(2021-1900, 2, 8, 12, 30, 12);
    	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
   	 	ServicioCrearCita instancia = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
   	 	
        //Act 
        Method metodoPrivado = instancia.getClass().getDeclaredMethod("obtenerSiguienteDiaHabil", new Class[]{Calendar.class});  
        metodoPrivado.setAccessible(true);
        Date resultado = (Date)metodoPrivado.invoke(instancia, new Object[]{calendario});

        //Assert
        assertEquals(fechaEsperada,resultado);  
    }
    
    
    @Test
    public void noSePuedeAgendarADoctorTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //Arrange		
        Cita cita = new CitaTestDataBuilder().build();
        List<Cita> listaCita = new ArrayList<Cita>();
      	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
   	 	ServicioCrearCita instancia = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
   	 	
   	 	listaCita.add(cita);

        //Act 
   	 	when(repositorioCita.obtenerListaCitas()).thenReturn(listaCita);

        Method metodoPrivado = instancia.getClass().getDeclaredMethod("sePuedeAgendarADoctor", new Class[]{Cita.class});  
        metodoPrivado.setAccessible(true);
        boolean resultado = (boolean)metodoPrivado.invoke(instancia, new Object[]{cita});

        //Assert
        assertFalse(resultado); 
    }
    
    @Test
    public void siSePuedeAgendarADoctorTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    	//Arrange
        Cita cita1 = new CitaTestDataBuilder().build();
        Cita cita2 = new CitaTestDataBuilder().build();
        cita2.setFechaCita(new Timestamp(new Date(2021-1900, 2, 11, 12, 30, 12).getTime()));
        List<Cita> listaCita = new ArrayList<Cita>();
      	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
   	 	ServicioCrearCita instancia = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
   	 	
   	 	listaCita.add(cita1);
   	 	
   	 	//Act
   	 	when(repositorioCita.obtenerListaCitas()).thenReturn(listaCita);
   	 	
        Method metodoPrivado = instancia.getClass().getDeclaredMethod("sePuedeAgendarADoctor", new Class[]{Cita.class});  
        metodoPrivado.setAccessible(true);
        boolean resultado = (boolean)metodoPrivado.invoke(instancia, new Object[]{cita2});

        //Assert
        assertTrue(resultado); 
    }
    
    @Test
    public void siExistePacienteTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    	//Arrange
        Paciente paciente = new PacienteTestDataBuilder().build();
        int codPaciente = paciente.getCodigo();
      	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
   	 	ServicioCrearCita instancia = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
   	 	
   	 	//Act
   	 	when(servicioObtenerPaciente.ejecutar(codPaciente)).thenReturn(paciente);
   	 	
        Method metodoPrivado = instancia.getClass().getDeclaredMethod("existePaciente", new Class[]{int.class});  
        metodoPrivado.setAccessible(true);
        boolean resultado = (boolean)metodoPrivado.invoke(instancia, new Object[]{codPaciente});

        //Assert
        assertTrue(resultado); 
    }
    
    @Test
    public void ejecutarAsignacionCitasTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    	//Arrange      	
    	RepositorioCita repositorioCita = mock(RepositorioCita.class);
   	 	ServicioObtenerPaciente servicioObtenerPaciente = mock(ServicioObtenerPaciente.class);
   	 	ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita,servicioObtenerPaciente);
   	 	Cita cita1 = new CitaTestDataBuilder().build();
   	 	
   	 	//Act
   	 	when(repositorioCita.agregar(cita1)).thenReturn(cita1);
   	 	Cita cita2 = servicioCrearCita.ejecutar(cita1);
   	 	
        //Assert
        assertEquals(cita1, cita2); 
    }


}

