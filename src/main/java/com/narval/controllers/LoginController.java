package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.narval.Services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login(Model model) {
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		if(auth.getPrincipal() instanceof UserDetails) {
			return "TouristDashboard";
		}
		return "login";
	}
	
}