package com.ceiba.clinicaodontologica.aplicacion.manejadores.paciente;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioObtenerPaciente;

@Component
public class ManejadorObtenerPaciente {

    private final ServicioObtenerPaciente servicioObtenerPaciente;

    public ManejadorObtenerPaciente(ServicioObtenerPaciente servicioObtenerPaciente) {
        this.servicioObtenerPaciente = servicioObtenerPaciente;
    }

    @Transactional
    public Paciente ejecutar(int codPaciente) {
        return this.servicioObtenerPaciente.ejecutar(codPaciente);
    }
	
}
