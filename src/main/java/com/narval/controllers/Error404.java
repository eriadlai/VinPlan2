package com.narval.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Error404 {

	@GetMapping("/Error404")
	public String login(Model model) {
		return "Error404";
	}
}
