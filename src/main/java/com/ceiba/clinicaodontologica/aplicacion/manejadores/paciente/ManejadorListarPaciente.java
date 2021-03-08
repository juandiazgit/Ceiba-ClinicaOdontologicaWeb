package com.ceiba.clinicaodontologica.aplicacion.manejadores.paciente;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioListarPaciente;

import java.util.List;

@Component
public class ManejadorListarPaciente {

    private final ServicioListarPaciente servicioListarPaciente;

    public ManejadorListarPaciente(ServicioListarPaciente servicioListarPaciente) {
        this.servicioListarPaciente = servicioListarPaciente;
    }

    @Transactional
    public List<Paciente> ejecutar() {
        return this.servicioListarPaciente.ejecutar();
    }
	
}
