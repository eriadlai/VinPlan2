package com.narval.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger logger = LoggerFactory.getLogger("SignUpController.class");

	@Autowired
	UserService userService;
	
	@GetMapping("/SignUp")
	public String SignUp(Model model) {
		
		return "SignUp";
	}
	@PostMapping("/SignUp")
	public String loginSubmit(@ModelAttribute UserRegistrationForm userRegistration, /*RedirectAttributes redirectAttributes,*/ Model model) {
		logger.info("New user registration");

		userService.addUser(userRegistration);
		
		return "redirect:/";
	}
}
