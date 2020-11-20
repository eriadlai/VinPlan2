package com.narval.Models;

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
@Table(name = "Vinicola", schema="vin-plan")
public class Vinicola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nombre", length=50, nullable=false, unique=false)
    private String nombre;

    @Column(name="direccion", length=50, nullable=true, unique=false)
    private String direccion;

    @Column(name="codigopost", length=10, nullable=false, unique=false)
    private int codigo_post;

    @Column(name="descripcion", length=999, nullable=true, unique=false)
    private String descripcion;
    
    @Column(name="logo", length=100, nullable=true, unique=false)
    private String logo;
    
    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPost() {
        return this.codigo_post;
    }

    public void setCodigoPost(int codigo_post) {
        this.codigo_post= codigo_post;
    }
//fin
    
}
