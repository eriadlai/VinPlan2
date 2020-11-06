package com.narval.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainMenuController {

	@GetMapping("/MainMenu")
	public String mainMenu(HttpServletRequest request, Model model) {
		return "MainMenu";
	}



}