package com.narval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.narval.Models.Vinicola;

@Repository
public interface VinicolaRepository extends JpaRepository<Vinicola,Integer>{

}
