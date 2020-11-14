package com.narval.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.narval.Dto.form.UserRegistrationForm;
import com.narval.Services.EmailService;
import com.narval.Services.RolesService;
import com.narval.Services.UserService;
import com.narval.repository.RolesRepository;
import com.narval.repository.TokenRepository;
import com.narval.Models.Roles;


@Controller
public class SignUpController {
	private static Logger logger = LoggerFactory.getLogger("SignUpController.class");

	@Autowired
	UserService userService;
	
	@Autowired
	RolesService rolesService;
	
	
	
	@GetMapping("/SignUp")
	public String SignUp(Model model) {
		List <String> roles= rolesService.getNames();
		
		model.addAttribute("roles",roles);
		return "SignUp";
	}
	@RequestMapping(value="/SignUp")
	public String signUp(@ModelAttribute UserRegistrationForm userRegistration, @RequestParam String role, Model model) {
		logger.info("New user registration");
		System.out.println(role);
		userService.addUser(userRegistration,role);
		
		return "redirect:/";
	}
}
