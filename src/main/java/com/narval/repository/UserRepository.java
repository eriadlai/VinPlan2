package com.narval.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.narval.Models.Usuario;


@Repository
public interface UserRepository extends CrudRepository<Usuario, Integer>{
	
	   	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	    public Usuario getUserByUsername(@Param("username") String username);
	   	
	   	@Query("SELECT u.id FROM Usuario u WHERE u.email = :email")
	   	public int getIdByEmail(@Param("email") String email);
	   	
	   	@Modifying
	   	@Query("update Usuario u set u.active = 1 where u.id= :id")
	   	void activateUser(@Param("id") int id);

}

