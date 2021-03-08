package com.ceiba.clinicaodontologica.aplicacion.manejadores.cita;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioListarCitaPorCodDoctor;
import com.ceiba.clinicaodontologica.dominio.servicio.paciente.ServicioListarPaciente;

import java.util.List;

@Component
public class ManejadorListarCitaPorCodDoctor {

    private final ServicioListarCitaPorCodDoctor servicioListarCitaPorCodDoctor;

    public ManejadorListarCitaPorCodDoctor(ServicioListarCitaPorCodDoctor servicioListarCitaPorCodDoctor) {
        this.servicioListarCitaPorCodDoctor = servicioListarCitaPorCodDoctor;
    }

    @Transactional
    public List<Cita> ejecutar(int codioDoctor) {
        return this.servicioListarCitaPorCodDoctor.ejecutar(codioDoctor);
    }
	
}
