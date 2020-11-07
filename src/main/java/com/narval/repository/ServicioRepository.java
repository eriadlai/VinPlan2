package com.narval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.narval.Models.Servicio;
import com.narval.Models.Usuario;


public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

	@Query(value="SELECT s.* from Servicio s LEFT JOIN Vinicola v on v.id = s.Vinicola_idVinicola where v.nombre = ?1", nativeQuery=true)
	List<Servicio> findByName(String name);
}
