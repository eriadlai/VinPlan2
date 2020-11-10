package com.narval.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.narval.Models.Token;


public interface TokenRepository extends JpaRepository<Token, String> {
	
}
