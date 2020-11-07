package com.narval.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.narval.Dto.ServicioDto;
import com.narval.Models.Servicio;
import com.narval.Services.ServiciosService;



@Controller
public class ServiciosController {
	
	
	@Autowired
	ServiciosService servicioService;
	

	
	@GetMapping("/Servicios")
	public String wineryServicesView(@RequestParam ("vinicolaNombre") String name, HttpServletRequest request, Model model) {
		String vinicolaName=name;
		
		List<Servicio> dbServicios = servicioService.findByName(vinicolaName);
		List<ServicioDto> servicios = new ArrayList<ServicioDto>();
		
		
		for (Servicio dbServicio: dbServicios) {
			ServicioDto servicioDto = new ServicioDto();
			
			servicioDto.setNombre(dbServicio.getNombre());
			servicioDto.setCosto(dbServicio.getCosto());
			servicioDto.setDescripcion(dbServicio.getDescripcion());
			
			
			servicios.add(servicioDto);
		}
		model.addAttribute("servicios", servicios);
		
		
		return "Servicios";
	}
	
}
