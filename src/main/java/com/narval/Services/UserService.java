package com.narval.Services;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.narval.Dto.form.UserRegistrationForm;
import com.narval.Models.Usuario;
import com.narval.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	 UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public List<Usuario> findAll() {
		
		List<Usuario> dbUsuarios = userRepository.findAll();
		
	    return dbUsuarios;
	}
	
	public Usuario findByEmail(String email) throws UsernameNotFoundException {
		
		Optional<Usuario> optionalUsuario = userRepository.findByEmail(email);
		
		optionalUsuario.orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + email));
		
		Usuario dbUsuario = optionalUsuario.get(); 
		
		
		return dbUsuario;
	}
	
	public boolean addUser(UserRegistrationForm userRegistration) {
		
		Usuario user = new Usuario();
		user.setUsername(userRegistration.getUsername());
		user.setEmail(userRegistration.getEmail());
		user.setName(userRegistration.getName());
		user.setHashed_password(passwordEncoder.encode(userRegistration.getPassword()));
		
		
		
		// Save record into database
		Usuario storedUser = userRepository.save(user);
		
		return storedUser != null ? true : false;
	}
	
}
