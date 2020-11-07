package com.narval.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narval.Models.Vinicola;
import com.narval.repository.VinicolaRepository;

@Service
public class VinicolaService {
	@Autowired
	VinicolaRepository vinicolaRepository;
	
	
	public List<Vinicola> findAll() {
		
		List<Vinicola> dbVinicolas = vinicolaRepository.findAll();
		
	    return dbVinicolas;
	}
}
