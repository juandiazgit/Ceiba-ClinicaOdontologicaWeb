package com.ceiba.clinicaodontologica.infraestructura.controllador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoCita;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.cita.ManejadorCrearCita;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.cita.ManejadorListarCitaPorCodDoctor;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.cita.ManejadorListarCitaPorCodPaciente;
import com.ceiba.clinicaodontologica.dominio.Cita;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ControladorCita {

    private final ManejadorListarCitaPorCodDoctor manejadorListarCitaPorCodDoctor;
    private final ManejadorCrearCita manejadorCrearCita;
    private final ManejadorListarCitaPorCodPaciente manejadorListarCitaPorCodPaciente;

    public ControladorCita(ManejadorListarCitaPorCodDoctor manejadorListarCitaPorCodDoctor, ManejadorCrearCita manejadorCrearCita,
    					   ManejadorListarCitaPorCodPaciente manejadorListarCitaPorCodPaciente) {
        this.manejadorListarCitaPorCodDoctor = manejadorListarCitaPorCodDoctor;
        this.manejadorCrearCita = manejadorCrearCita;
        this.manejadorListarCitaPorCodPaciente = manejadorListarCitaPorCodPaciente;
    }

    @GetMapping("/Doctor/{codDoctor}")
    public List<Cita> buscarCitasDoctor(@PathVariable int codDoctor) {
        return this.manejadorListarCitaPorCodDoctor.ejecutar(codDoctor);
    }
    
	@PostMapping
	public Cita asignarCita(@RequestBody ComandoCita comandoCita) {
		return this.manejadorCrearCita.ejecutar(comandoCita);
	}
	
    @GetMapping("/Paciente/{codPaciente}")
    public List<Cita> buscarCitasPaciente(@PathVariable int codPaciente) {
        return this.manejadorListarCitaPorCodPaciente.ejecutar(codPaciente);
    }
	
}
