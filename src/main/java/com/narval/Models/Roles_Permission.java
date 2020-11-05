package com.narval.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Roles_Permission", schema="vin-plan")
public class Roles_Permission {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Roles_id", referencedColumnName = "id")
    private Roles roles;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Permisos_id", referencedColumnName = "id")
    private Permisos permisos;

    public Roles getRoles() {
        return this.roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Permisos getPermisos() {
        return this.permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

}
