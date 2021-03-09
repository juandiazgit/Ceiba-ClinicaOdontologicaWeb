package com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.ceiba.clinicaodontologica.dominio.Doctor;

@Entity(name = "Cita")
public class CitaEntity implements Serializable{

	@Id
	@Column(name = "cit_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(name = "cit_proced")
	private String procedimiento;
	
	@Column(name = "cit_fecha")
	private Date fechaCita;
	
	@ManyToOne(cascade = {CascadeType.ALL})//(fetch = FetchType.LAZY)
    @JoinColumn(name = "cit_paccod", referencedColumnName = "pac_cod")
    private PacienteEntity paciente;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cit_doccod", referencedColumnName = "doc_cod")
    private DoctorEntity doctor;
    
    @ManyToOne
    @JoinColumn(name = "cit_facid", referencedColumnName = "fac_id")
    private FacturaEntity factura;

	public CitaEntity() {}
    
    public CitaEntity(String procedimiento, Date fechaCita, PacienteEntity paciente, DoctorEntity doctor,
			FacturaEntity factura) {
		super();
		this.procedimiento = procedimiento;
		this.fechaCita = fechaCita;
		this.paciente = paciente;
		this.doctor = doctor;
		this.factura = factura;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}
    
}
