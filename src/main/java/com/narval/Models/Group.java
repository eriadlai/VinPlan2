package com.narval.Models;



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
@Table(name = "Group", schema="vin-plan")
public class Group {
    

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Roles_id", referencedColumnName = "id")
    private Roles roles;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Vinicola_idVinicola", referencedColumnName = "id")
    private Vinicola vinicola;

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

    public Roles getRoles() {
        return this.roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Vinicola getVinicola() {
        return this.vinicola;
    }

    public void setVinicola(Vinicola vinicola) {
        this.vinicola = vinicola;
    }

}
