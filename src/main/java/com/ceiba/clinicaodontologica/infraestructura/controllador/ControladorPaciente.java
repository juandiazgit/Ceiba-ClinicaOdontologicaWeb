package com.ceiba.clinicaodontologica.infraestructura.controllador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoPaciente;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.paciente.ManejadorCrearPaciente;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.paciente.ManejadorListarPaciente;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.paciente.ManejadorObtenerPaciente;
import com.ceiba.clinicaodontologica.dominio.Paciente;

@RestController
@RequestMapping("/pacientes")
public class ControladorPaciente {

    private final ManejadorObtenerPaciente manejadorObtenerPaciente;
    private final ManejadorListarPaciente manejadorListarPaciente;
    private final ManejadorCrearPaciente manejadorCrearPaciente;

    public ControladorPaciente(ManejadorObtenerPaciente manejadorObtenerPaciente, 
    						   ManejadorListarPaciente manejadorListarPaciente,
    						   ManejadorCrearPaciente manejadorCrearPaciente) {
        this.manejadorObtenerPaciente = manejadorObtenerPaciente;
        this.manejadorListarPaciente = manejadorListarPaciente;
        this.manejadorCrearPaciente = manejadorCrearPaciente;
    }

    @GetMapping("/{codPaciente}")
    public Paciente buscar(@PathVariable int codPaciente) {
        return this.manejadorObtenerPaciente.ejecutar(codPaciente);
    }

    @GetMapping("/listar")
    public List<Paciente> listar() {
        return this.manejadorListarPaciente.ejecutar();
    }
    
	@PostMapping
	public Paciente registrarPaciente(@RequestBody ComandoPaciente comandoPaciente) {
		return this.manejadorCrearPaciente.ejecutar(comandoPaciente);
	}
	
}
