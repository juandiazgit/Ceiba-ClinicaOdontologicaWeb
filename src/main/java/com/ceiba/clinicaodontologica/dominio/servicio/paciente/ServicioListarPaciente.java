package com.ceiba.clinicaodontologica.dominio.servicio.paciente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.RepositorioPaciente;

@Service
public class ServicioListarPaciente {

    private final RepositorioPaciente repositorioPaciente;

    public ServicioListarPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public List<Paciente> ejecutar() {
        return repositorioPaciente.listaPaciente();
    }
	
}
