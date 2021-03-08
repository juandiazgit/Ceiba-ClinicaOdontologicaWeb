package com.ceiba.clinicaodontologica.infraestructura.controllador;

import org.springframework.web.bind.annotation.*;

import com.ceiba.clinicaodontologica.aplicacion.manejadores.paciente.ManejadorListarPaciente;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.paciente.ManejadorObtenerPaciente;
import com.ceiba.clinicaodontologica.dominio.Paciente;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class ControladorPaciente {

    private final ManejadorObtenerPaciente manejadorObtenerPaciente;
    private final ManejadorListarPaciente manejadorListarPaciente;

    public ControladorPaciente(ManejadorObtenerPaciente manejadorObtenerPaciente, 
    						   ManejadorListarPaciente manejadorListarPaciente) {
        this.manejadorObtenerPaciente = manejadorObtenerPaciente;
        this.manejadorListarPaciente = manejadorListarPaciente;
    }

    @GetMapping("/{codPaciente}")
    public Paciente buscar(@PathVariable int codPaciente) {
        return this.manejadorObtenerPaciente.ejecutar(codPaciente);
    }

    @GetMapping("/listar")
    public List<Paciente> listar() {
        return this.manejadorListarPaciente.ejecutar();
    }
	
}
