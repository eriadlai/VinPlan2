package com.narval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.narval.Models.Roles;
import com.narval.Models.Servicio;
import com.narval.Models.Usuario;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
   	@Query("SELECT r FROM Roles r WHERE r.name = :name")
    public Roles getRoleByName(@Param("name") String name);
}
