package com.narval.Dto;

import java.sql.Timestamp;

public class ServicioDto {

	private int id;
	private String nombre;
	private String tipo;
	private Double costo;
	private String descripcion;
	private Timestamp fechaInicio;
	private Timestamp fechaFinal;
	private int Vinicola_idVinicola;
	private Timestamp last_update;
	
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Timestamp getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public int getVinicola_idVinicola() {
		return Vinicola_idVinicola;
	}
	public void setVinicola_idVinicola(int vinicola_idVinicola) {
		Vinicola_idVinicola = vinicola_idVinicola;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public int getMaximoAforo() {
		return maximoAforo;
	}
	public void setMaximoAforo(int maximoAforo) {
		this.maximoAforo = maximoAforo;
	}
	private int maximoAforo;
	

}
