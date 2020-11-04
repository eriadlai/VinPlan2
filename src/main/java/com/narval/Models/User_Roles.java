package com.narval.Models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User_Roles", schema="vin-plan")
public class User_Roles {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Roles_id", referencedColumnName = "id")
    private Roles roles;
}
