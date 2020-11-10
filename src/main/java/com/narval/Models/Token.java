package com.narval.Models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tokens", schema="vin-plan")
public class Token {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="token")
	private String token;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id", referencedColumnName = "id")    
	private Usuario usuario;
	
	@Column(name="expiration_time", nullable=true)
	private Date expirationTime;
	
	@Column(name="active", nullable=false)
	private boolean active;

	public Token() {
	    	
	}
	
	public Token(Usuario user) {
		this.usuario=user;
	    this.active=false;    	
	}
	public String getToken() {
		return token;
	}
  
 
	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUserId() {
		return usuario;
	}

	public void setUserId(Usuario user) {
		this.usuario = user;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
