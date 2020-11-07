package com.narval.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narval.Models.Servicio;
import com.narval.Models.Vinicola;
import com.narval.repository.ServicioRepository;
import com.narval.repository.VinicolaRepository;



@Service
public class ServiciosService {
	@Autowired
	ServicioRepository servicioRepository;
	
	
	public List<Servicio> findByName(String name) {
		
		List<Servicio> dbServicios = servicioRepository.findByName(name);
		
	    return dbServicios;
	}
}
