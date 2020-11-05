package com.narval.Models;

import java.sql.Timestamp;

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
@Table(name = "ReservacionEspecifica", schema = "wine-tour-planner")
public class ReservacionEspecifica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="especificaciones", length = 500, nullable=false, unique = false)
    private String especificaciones;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Servicio_idServicio", referencedColumnName = "id")
    private Servicio servicio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Status_idStatus", referencedColumnName = "id")
    private Status status;

    @Column(name="fechainicio", nullable = false)
    private Timestamp fechainicio;

    @Column(name="fechaFinal", nullable = false)
    private Timestamp fechaFinal;

    @Column(name="Vinicola_idvinicola", nullable = false)
    private int Vinicola_idVinicola;

    @Column(name="last_update", nullable = false)
    private Timestamp last_update;

    @Column(name="maximoAforo", nullable = false)
    private int maximoAforo;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecificaciones() {
        return this.especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public Servicio getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getFechainicio() {
        return this.fechainicio;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Timestamp getFechaFinal() {
        return this.fechaFinal;
    }

    public void setFechaFinal(Timestamp fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getVinicola_idVinicola() {
        return this.Vinicola_idVinicola;
    }

    public void setVinicola_idVinicola(int Vinicola_idVinicola) {
        this.Vinicola_idVinicola = Vinicola_idVinicola;
    }

    public Timestamp getLast_update() {
        return this.last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public int getMaximoAforo() {
        return this.maximoAforo;
    }

    public void setMaximoAforo(int maximoAforo) {
        this.maximoAforo = maximoAforo;
    }
    
}
