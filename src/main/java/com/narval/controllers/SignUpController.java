package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.narval.Dto.form.UserRegistrationForm;
import com.narval.Services.UserService;

@Controller
public class SignUpController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/SignUp")
	public String SignUp(Model model) {
		
		return "SignUp";
	}
	@PostMapping("/SignUp")
	public String loginSubmit(@ModelAttribute UserRegistrationForm userRegistration, /*RedirectAttributes redirectAttributes,*/ Model model) {
		
		userService.addUser(userRegistration);
		
		
		return "redirect:/";
	}
}
