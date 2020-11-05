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

import com.narval.model.Winery;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicio", schema="wine-tour-planner")
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
	
	@Column(name="fechaInicio", nullable=false, unique=false)
	private Date fechaIncicio;
	
	@Column(name="fechaFinal", nullable=false)
	private Date fechaFinal;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "winery_id", referencedColumnName = "id")
    private Winery winery;
}
