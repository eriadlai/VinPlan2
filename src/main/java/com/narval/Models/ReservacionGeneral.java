package com.narval.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Regions", schema = "wine-tour-planner")
public class ReservacionGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Reservacion_Especifica_idReservacion", referencedColumnName = "id")
    private ReservacionEspecifica reservacionespecifica;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ReservacionEspecifica getReservacionespecifica() {
        return this.reservacionespecifica;
    }

    public void setReservacionespecifica(ReservacionEspecifica reservacionespecifica) {
        this.reservacionespecifica = reservacionespecifica;
    }

}
