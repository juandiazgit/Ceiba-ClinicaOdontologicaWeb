package com.ceiba.clinicaodontologica.aplicacion.manejadores.cita;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioListarCitaPorCodPaciente;

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
