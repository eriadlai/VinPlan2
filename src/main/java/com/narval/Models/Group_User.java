package com.narval.Models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Group_User", schema="vin-plan")
public class Group_User {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Vinicola_id", referencedColumnName = "id")
    private Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Vinicola_id", referencedColumnName = "id")
    private Usuario usuariol;

}
