package com.ceiba.clinicaodontologica.infraestructura.persistencia.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Factura")
public class FacturaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "fac_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fac_fecha")
    private Date fechaGeneracion;
   
    @Column(name = "fac_valor")
    private double valorPagar;
   
	public FacturaEntity(Date fechaGeneracion, double valorPagar) {
		this.fechaGeneracion = (Date) fechaGeneracion.clone();
		this.valorPagar = valorPagar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaGeneracion() {
		return (Date) fechaGeneracion.clone();
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = (Date) fechaGeneracion.clone();
	}

	public double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}

}
