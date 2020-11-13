package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.narval.Dto.form.VinRegistrationForm;
import com.narval.Services.VinicolaService;

@Controller
public class RegistroVinicolaController {

	
	@Autowired
	VinicolaService vinicolaService;
	
	@GetMapping("/registroVinicola")
    public String RegistroVinicola(Model model) {
        return "registroVinicola";
    }	
	
	@PostMapping("/registroVinicola")
	public String registroVinicola(@ModelAttribute VinRegistrationForm vinRegistrationForm, Model model) {
		
		vinicolaService.addVinicola(vinRegistrationForm);
		
		return "redirect:/MainMenu";

	}
	
}
