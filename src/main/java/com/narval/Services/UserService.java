package com.narval.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.narval.Dto.form.UserRegistrationForm;
import com.narval.Models.Roles;
import com.narval.Models.Token;
import com.narval.Models.Usuario;
import com.narval.repository.RolesRepository;
import com.narval.repository.TokenRepository;
import com.narval.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	 UserRepository userRepository;
	
	@Autowired
	RolesRepository rolesRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired 
	TokenRepository tokenRepository;
	
	@Autowired
	EmailService emailService;
	
	
	public boolean addUser(UserRegistrationForm userRegistration,String role) {
		
		System.out.println(role);
		Usuario user = new Usuario();
		user.setUsername(userRegistration.getUsername());
		user.setEmail(userRegistration.getEmail());
		user.setName(userRegistration.getName());
		user.setHashed_password(passwordEncoder.encode(userRegistration.getPassword()));
		user.setLastname(userRegistration.getLastname());
		user.setActive(0);
		System.out.println(role);
		Roles rol=rolesRepository.getRoleByName(role);
		user.addRoll(rol);
		rol.addUser(user);
		rolesRepository.save(rol);
		if(userRepository.getUserByUsername(user.getUsername())!=null) {
			return false;
		}
		
		Token confirmationToken =new Token(user);
		confirmationToken.setToken(UUID.randomUUID().toString());
		System.out.println(confirmationToken.getToken());
		tokenRepository.save(confirmationToken);
		
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("No reply");
		mailMessage.setFrom("david.murillo@cetys.edu.mx");
		mailMessage.setText("Para confirmar tu cuenta, por favor, ingrese al siguiente link \n"
		+"http://localhost:8080/confirm-account?token="+confirmationToken.getToken());
		emailService.sendEmail(mailMessage);
		
		return true;

	}

	
}
