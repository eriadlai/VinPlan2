package com.narval.Dto;

import java.util.List;


public class VinicolaDto {
	private int id;
	private String nombre;
	private String direccion;
	private int codigo_post;
	

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
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getCodigo_post() {
		return codigo_post;
	}
	public void setCodigo_post(int codigoPost) {
		this.codigo_post=codigoPost;
	}
	

	

}
