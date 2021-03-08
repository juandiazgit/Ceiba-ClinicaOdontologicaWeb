package com.ceiba.clinicaodontologica.aplicacion.manejadores.cita;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioListarCitaPorCodDoctor;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioListarCitaPorCodPaciente;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioListarPaciente;

import java.util.List;

@Component
public class ManejadorListarCitaPorCodPaciente {

    private final ServicioListarCitaPorCodPaciente servicioListarCitaPorCodPaciente;

    public ManejadorListarCitaPorCodPaciente(ServicioListarCitaPorCodPaciente servicioListarCitaPorCodPaciente) {
        this.servicioListarCitaPorCodPaciente = servicioListarCitaPorCodPaciente;
    }

    @Transactional
    public List<Cita> ejecutar(int codPaciente) {
        return this.servicioListarCitaPorCodPaciente.ejecutar(codPaciente);
    }
	
}
