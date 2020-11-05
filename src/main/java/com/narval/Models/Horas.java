package com.narval.Models;

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
@Table(name = "Horas",schema="vin-plan")
public class Horas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="horaApertura",length=50,nullable=false)
	private int horaApertura;

	@Column(name="horaCierrre",length=50,nullable=false)
	private int horaCierre;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Servicio_idServicio",referencedColumnName = "id")
	private Servicio servicio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Dias_IdDias",referencedColumnName = "id")
	private Dias dias;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Vinicola_idVinicola",referencedColumnName = "id")
	private Vinicola vinicola;
}
