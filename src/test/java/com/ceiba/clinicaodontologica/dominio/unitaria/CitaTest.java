
package com.ceiba.clinicaodontologica.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
public class CitaTest {

    private static final String PROCEDIMIENTO = "Ortodoncia";
    private static final Date FECHACITA = new Date(2021-1900, 2, 8, 12, 30, 12);

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

}

