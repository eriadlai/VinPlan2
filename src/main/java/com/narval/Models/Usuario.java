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
@Table(name = "Usuarios", schema="vin-plan")
public class Usuario {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Username", length=50, nullable=false, unique=false)
    private int Username;

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="lastname", length=50, nullable=false, unique=false)
    private String lastname;

    @Column(name="hashed_password", length=100, nullable=false, unique=false)
    private String hashed_password;

    @Column(name="email", length=254, nullable=false, unique=false)
    private String email;

    @Column(name="gender", length=10, nullable=false, unique=false)
    private String gender;

    @Column(name="birthday", length=45, nullable=false, unique=false)
    private Timestamp birthday;

    @Column(name="number_visits", length=45, nullable=false, unique=false)
    private int number_visits;

    @Column(name="knowledge_level", length=20, nullable=false, unique=false)
    private String knowledge_level;

    @Column(name="google", length=50, nullable=false, unique=false)
    private String google;

    @Column(name="facebook", length=50, nullable=false, unique=false)
    private String facebook;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Tipo_Usuario_id", referencedColumnName = "id")
    private Tipo_Usuario tipo_usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Vinicola_id", referencedColumnName = "id")
    private Vinicola vinicola;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsername() {
        return this.Username;
    }

    public void setUsername(int Username) {
        this.Username = Username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHashed_password() {
        return this.hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public int getNumber_visits() {
        return this.number_visits;
    }

    public void setNumber_visits(int number_visits) {
        this.number_visits = number_visits;
    }

    public String getKnowledge_level() {
        return this.knowledge_level;
    }

    public void setKnowledge_level(String knowledge_level) {
        this.knowledge_level = knowledge_level;
    }

    public String getGoogle() {
        return this.google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getFacebook() {
        return this.facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Tipo_Usuario getTipo_usuario() {
        return this.tipo_usuario;
    }

    public void setTipo_usuario(Tipo_Usuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public Vinicola getVinicola() {
        return this.vinicola;
    }

    public void setVinicola(Vinicola vinicola) {
        this.vinicola = vinicola;
    }

}
