package com.narval.Models;

import java.math.BigInteger;
import java.security.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Servicio",schema="vin-plan")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	@Column(name="nombre",length=30,nullable=false,unique=false)
	private String nombre;
	
	@Column(name="tipo",length=50,nullable=false,unique=false)
	private String tipo;
	
	@Column(name="costo",length=50,nullable=false,unique=false)
	private Double costo;
	
	@Column(name="descripcion",length=500,nullable=false,unique=false)
	private String descripcion;
	
	@Column(name="fechaInicio",length=50,nullable=false,unique=false)
	private Timestamp fechaInicio;
	
	@Column(name="fechaFinal",length=50,nullable=false,unique=false)
	private Timestamp fechaFinal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Vinicola_idVinicola",referencedColumnName = "id")
	private Vinicola Vinicola_idVinicola;
	
	@Column(name="last_update",length=50,nullable=false,unique=false)
	private int last_update;
	
	@Column(name="maximoAforo",length=50,nullable=false,unique=false)
	private int maximoAforo;
}
