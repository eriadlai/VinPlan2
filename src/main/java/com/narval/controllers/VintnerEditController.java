package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.narval.Dto.form.VinicolaEditForm;
import com.narval.Services.VinicolaService;


@Controller
public class VintnerEditController {
	
	@Autowired
	VinicolaService vinicolaService;

	@GetMapping("/VinicolaEdit")
	public String VinicolaEdit(Model model) {
		return "VinicolaEdit";
	}
	
	@PostMapping("/VinicolaEdit")
	public void VinicolaEdit(@ModelAttribute VinicolaEditForm vinicolaEditForm, /*RedirectAttributes redirectAttributes,*/ Model model) {
		vinicolaService.EditVinicola(vinicolaEditForm);
	}

	
}
