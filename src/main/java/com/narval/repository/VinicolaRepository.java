package com.narval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.narval.Models.Vinicola;

@Repository
public interface VinicolaRepository extends JpaRepository<Vinicola,Integer>{
	
  	@Query("SELECT v FROM Vinicola v WHERE v.direccion= :direccion")
    public List<Vinicola> getWineryByLocation(@Param("direccion") String direccion);
   	
	
}
