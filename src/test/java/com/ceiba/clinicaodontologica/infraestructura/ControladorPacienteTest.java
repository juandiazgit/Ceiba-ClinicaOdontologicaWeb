package com.ceiba.clinicaodontologica.infraestructura;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest
public class ControladorPacienteTest {
	
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
    
	@Test
	public void getListaCitaPorPaciente() throws Exception {
	 
	final int CODIGO_PACIENTE = 1010;
		  
		mvc.perform(MockMvcRequestBuilders
	            .get("/pacientes/listar", CODIGO_PACIENTE)
	            .accept(MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isOk())
	            .andExpect(MockMvcResultMatchers.jsonPath("$[0].codigo").value(CODIGO_PACIENTE));
	  }
	
	@Test
	public void getListaCitaPorCodPaciente() throws Exception {
		 
	final int CODIGO = 2020;
	final String NOMBRE = "Camila";
	final String APELLIDO = "Bermudez";
	final int EDAD = 32;
	final String TELEFONO = "312665464";
	
			  
	mvc.perform(MockMvcRequestBuilders
	        .get("/pacientes/{codPaciente}", CODIGO)
	        .accept(MediaType.APPLICATION_JSON))
	        .andDo(print())
	        .andExpect(status().isOk())
	        .andExpect(MockMvcResultMatchers.jsonPath("$.codigo").value(CODIGO))
	        .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(NOMBRE))
	        .andExpect(MockMvcResultMatchers.jsonPath("$.apellido").value(APELLIDO))
	        .andExpect(MockMvcResultMatchers.jsonPath("$.edad").value(EDAD))
	        .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value(TELEFONO));
	}
	
}

