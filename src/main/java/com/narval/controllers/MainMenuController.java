package com.narval.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainMenuController {
	@Value("${spring.application.name}")
	String appName;
	
	@PostMapping("/MainMenu")
    public String MainMenu(Model model) {
        model.addAttribute("appName", appName);
        return "MainMenu";
    }	



}