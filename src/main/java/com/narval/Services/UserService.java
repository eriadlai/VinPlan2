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
import com.narval.Models.User;
import com.narval.Models.Usuario;

@Service
public class UserService {
	
	@Autowired
	com.narval.repository.UserRepository userRepository;
	
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
		
		user.setEmail(userRegistration.getEmail());
		user.setName(userRegistration.getName());
		user.setHashed_password(passwordEncoder.encode(userRegistration.getPassword()));
		
		/*switch(userRegistration.getRole()) {
			case "Administrator":
				user.setRole("ROLE_ADMIN"); 
			    break;
			case "Vintner":
				user.setRole("ROLE_VINTNER");
			    break;
			default:
				user.setRole("ROLE_TOURIST");
		}*/
		
		// Save record into database
		int storedUser = userRepository.save(user);
		
		return storedUser == 0 ? true : false;
	}
	
}
