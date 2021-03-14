package com.ceiba.clinicaodontologica.aplicacion.manejadores.paciente;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoPaciente;
import com.ceiba.clinicaodontologica.aplicacion.fabrica.FabricaPaciente;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioCrearPaciente;

@Component
public class ManejadorCrearPaciente {

    private final ServicioCrearPaciente servicioCrearPaciente;
    private final FabricaPaciente fabricaPaciente;

    public ManejadorCrearPaciente(ServicioCrearPaciente servicioCrearPaciente, FabricaPaciente fabricaPaciente) {
        this.servicioCrearPaciente = servicioCrearPaciente;
        this.fabricaPaciente = fabricaPaciente;
    }

    @Transactional
    public Paciente ejecutar(ComandoPaciente comandoPaciente) {
    	Paciente paciente = this.fabricaPaciente.crearPaciente(comandoPaciente);
        return this.servicioCrearPaciente.ejecutar(paciente);
    }
}
