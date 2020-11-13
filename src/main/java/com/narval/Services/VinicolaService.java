package com.narval.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narval.Dto.form.VinRegistrationForm;
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
	
	public boolean addVinicola(VinRegistrationForm vinRegistrationForm){
		Vinicola vin= new Vinicola();
		vin.setNombre(vinRegistrationForm.getNombre());
		vin.setDireccion(vinRegistrationForm.getDireccion());
		vin.setCodigoPost(vinRegistrationForm.getCodigo_post());
		vinicolaRepository.save(vin);
		
		return true;
	}
}
