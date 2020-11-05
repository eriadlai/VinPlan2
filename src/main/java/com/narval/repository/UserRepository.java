package com.narval.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.narval.Models.Usuario;



@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
	

	Optional<Usuario> findByEmail(String email);

	@Override
	@Query("select u from Usuario u")
	List<Usuario> findAll();

    
}
