package com.narval.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.narval.Dto.VinicolaDto;
import com.narval.Models.Vinicola;
import com.narval.Services.VinicolaService;


@Controller
public class VinicolaController {
	@Value("${spring.application.name}")
	String appName;
	@Autowired
	VinicolaService vinicolaService;
	
	
	@RequestMapping(value="/Vinicola", method = RequestMethod.GET)
    public String MainMenu(Model model) {
		
		
		
		List<Vinicola> dbVinicolas = vinicolaService.findAll();
		
		List<VinicolaDto> vinicolas = new ArrayList<VinicolaDto>();
		
		for (Vinicola dbVinicola: dbVinicolas) {
			VinicolaDto vinicolaDto = new VinicolaDto();
			
			vinicolaDto.setId(dbVinicola.getId());
			vinicolaDto.setNombre(dbVinicola.getNombre());
			vinicolaDto.setDireccion(dbVinicola.getDireccion());
			vinicolaDto.setCodigo_post(dbVinicola.getCodigoPost());

			vinicolas.add(vinicolaDto);
		}
		
		model.addAttribute("vinicolas", vinicolas);
		
        return "Vinicola";
    }	
}
