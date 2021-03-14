
package com.ceiba.clinicaodontologica.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.clinicaodontologica.testdatabuilder.PacienteTestDataBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
public class PacienteTest {

	private static final int CCODIGO = 1578;
	private static final String NOMBRE = "Rosa";
	private static final String APELLIDO = "Marquez";
	private static final int EDAD = 48;
	private static final String TELEFONO = "32166588";

	@Test
	public void crearPacienteTest() {

		// arrange
		PacienteTestDataBuilder pacienteTestDataBuilder = new PacienteTestDataBuilder().
				conCodigo(CCODIGO).conNombre(NOMBRE).conApellido(APELLIDO).conEdad(EDAD).
				conTelefono(TELEFONO);

		// act
		Paciente paciente = pacienteTestDataBuilder.build();

		// assert
		assertTrue(CCODIGO==paciente.getCodigo());
		assertTrue(NOMBRE.equals(paciente.getNombre()));
		assertTrue(APELLIDO.equals(paciente.getApellido()));
		assertTrue(EDAD==paciente.getEdad());
		assertTrue(TELEFONO.equals(paciente.getTelefono()));
	}

}
