package com.narval.Models;

import java.math.BigInteger;
import java.security.Timestamp;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.narval.Models.Vinicola;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicio", schema="vin-plan")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="nombre", length=30, nullable=false, unique=true)
	private String nombre;
	
	@Column(name="costo", length=50, nullable=false, unique=false)
	private Double costo;
	
	@Column(name="descripcion", length=500, nullable=false, unique=false)
	private String descripcion;
	
	@Column(name="fechainicio", nullable=true, unique=false)
	private Date fechaIncicio;
	
	@Column(name="fechafinal", nullable=true)
	private Date fechaFinal;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Vinicola_idvinicola", referencedColumnName = "id")
    private Vinicola vinicola;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaIncicio() {
		return fechaIncicio;
	}

	public void setFechaIncicio(Date fechaIncicio) {
		this.fechaIncicio = fechaIncicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Vinicola getVinicola() {
		return vinicola;
	}

	public void setVinicola(Vinicola vinicola) {
		this.vinicola = vinicola;
	}
}
