
package com.ceiba.clinicaodontologica.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Doctor;
import com.ceiba.clinicaodontologica.dominio.Factura;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.builder.CitaBuilder;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.CitaEntity;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.DoctorEntity;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.FacturaEntity;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad.PacienteEntity;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.clinicaodontologica.testdatabuilder.DoctorTestDataBuilder;
import com.ceiba.clinicaodontologica.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.clinicaodontologica.testdatabuilder.PacienteTestDataBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
public class CitaTest {

    private static final String PROCEDIMIENTO = "ORTODONCIA";
    @SuppressWarnings("deprecation")
	private static final Date FECHACITA = new Date(2021-1900, 2, 16, 12, 30, 12);
    
    @Test
    public void crearCitaTest() {

        // arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().
                conProcedimiento(PROCEDIMIENTO).
                conFechaCita(FECHACITA);

        // act
        Cita cita = citaTestDataBuilder.build();

        // assert
        assertEquals(PROCEDIMIENTO, cita.getProcedimiento());
        assertEquals(new Timestamp(FECHACITA.getTime()), cita.getFechaCita());
    }
    
    @Test
    public void citaBuilderConvertirADominioTest() {

    	//Arrange
        Paciente paciente = new PacienteTestDataBuilder().build();
        Doctor doctor = new DoctorTestDataBuilder().build();
        Factura factura = new FacturaTestDataBuilder().build2();
        double valorPagar = 150000;

        //Act
        CitaEntity citaEntity = new CitaEntity();
        citaEntity.setFactura(new FacturaEntity(factura.getFechaGeneracion(), factura.getValorPagar()));
        citaEntity.setPaciente(new PacienteEntity(paciente.getCodigo(),
		        								  paciente.getNombre(),
		        								  paciente.getApellido(),
		        								  paciente.getEdad(),
		        								  paciente.getTelefono()));
        citaEntity.setDoctor(new DoctorEntity(doctor.getCodigo(),
        									  doctor.getNombre(),
        									  doctor.getApellido(),
        									  doctor.getEspecializacion()));
        citaEntity.setProcedimiento(PROCEDIMIENTO);
        citaEntity.setFechaCita(FECHACITA);
        
        
        CitaBuilder.convertirADominio(citaEntity);
        
        // assert
        assertTrue(valorPagar == citaEntity.getFactura().getValorPagar());
    }
    
    @Test
    public void citaBuilderConvertirAEntityTest() {

        // arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().
                conProcedimiento(PROCEDIMIENTO).
                conFechaCita(FECHACITA);

        // act
        Cita cita = citaTestDataBuilder.build();
        
        CitaEntity citaEntity = CitaBuilder.convertirAEntity(cita);

        // assert
        assertEquals(PROCEDIMIENTO, citaEntity.getProcedimiento());
    }
    
    @Test
    public void citaBuilderConvertirAEntityFacturaNoNullTest() {

        // arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().
                conProcedimiento(PROCEDIMIENTO).
                conFechaCita(FECHACITA);
        Cita cita = citaTestDataBuilder.build();
        Factura factura = new FacturaTestDataBuilder().build2();

        // act
        cita.setFactura(factura);
        
        CitaEntity citaEntity = CitaBuilder.convertirAEntity(cita);

        // assert
        assertEquals(PROCEDIMIENTO, citaEntity.getProcedimiento());
    }

}

