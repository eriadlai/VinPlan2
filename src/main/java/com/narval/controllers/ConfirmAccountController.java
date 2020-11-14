package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.narval.Models.Token;
import com.narval.Models.Usuario;
import com.narval.repository.RolesRepository;
import com.narval.repository.TokenRepository;
import com.narval.repository.UserRepository;

@Controller
public class ConfirmAccountController {
   
	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired 
	UserRepository userRepository;
	@Autowired
	RolesRepository rolesRepository;
	
	@RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	public String confirmUserAccount(@RequestParam("token")String confirmationTokenString) {
		Token token=tokenRepository.findByToken(confirmationTokenString);
		if(token!=null) {
			Usuario user=userRepository.getUserByUsername(token.getUserId().getUsername());
			user.setActive(1);
			userRepository.save(user);
		}
		
		return "login";
		
	
	}
}
