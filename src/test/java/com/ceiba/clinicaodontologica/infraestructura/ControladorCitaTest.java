package com.ceiba.clinicaodontologica.infraestructura;
//
//import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoCita;
//import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.web.JsonPath;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//import java.util.Date;
//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//public class ControladorCitaTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void asignarCitaPacienteTest() throws Exception {
//    	
//    	final String PROCEDIMIENTO = "Ortodoncia";
//		final Date FECHACITA = new Date(2021-1900, 2, 8, 14, 50, 12);
//        
//        ComandoCita comandoCita = new CitaTestDataBuilder().conProcedimiento(PROCEDIMIENTO).
//        		                                            conFechaCita(FECHACITA).
//        		                                            buildComando();
//        mvc.perform(MockMvcRequestBuilders
//                .post("/citas")
//                .content(objectMapper.writeValueAsString(comandoCita))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//        //Verificar.
//    }
//    
//	  @Test
//	  public void getCitaPorCodDoctor() throws Exception {
//		  
//		  final int CODIGO_DOCTOR = 1010;
//		  
//	      mvc.perform(MockMvcRequestBuilders
//	              .get("/citas/Doctor/{codDoctor}", CODIGO_DOCTOR)
//	              .accept(MediaType.APPLICATION_JSON))
//	              .andDo(print())
//	              .andExpect(status().isOk())
//	              .andExpect(MockMvcResultMatchers.jsonPath("$[0].doctor.codigo").value(CODIGO_DOCTOR));
//	  }
//	  
//	  @Test
//	  public void getCitaPorCodPaciente() throws Exception {
//		  
//		  final int CODIGO_PACIENTE = 2020;
//		  
//	      mvc.perform(MockMvcRequestBuilders
//	              .get("/citas/Paciente/{codPaciente}", CODIGO_PACIENTE)
//	              .accept(MediaType.APPLICATION_JSON))
//	              .andDo(print())
//	              .andExpect(status().isOk())
//	              .andExpect(MockMvcResultMatchers.jsonPath("$[0].paciente.codigo").value(CODIGO_PACIENTE));
//	  }
//  
//}
