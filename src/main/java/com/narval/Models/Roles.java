package com.narval.Models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Entity
@Table(name = "Roles", schema="vin-plan")
public class Roles {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="description", length=1000, nullable=false, unique=false)
    private String description;
    
    @ManyToMany(mappedBy= "roles", fetch = FetchType.EAGER)
    private Set<Usuario> usuarios= new HashSet<>();
    
    public Set<Usuario> getUsuarios(){
    	return this.usuarios;
    }
    public void addUser(Usuario user) {
    	this.usuarios.add(user);
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     
}
