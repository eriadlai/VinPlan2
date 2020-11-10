package com.narval.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.narval.Models.MyUserDetails;
import com.narval.Models.Usuario;
import com.narval.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Usuario user = userRepository.getUserByUsername(username);
         
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	            
	        }
	        
	        if(user.isActive()==0) {
	            throw new UsernameNotFoundException("El usuario no ha sido verificado");
	        }
	        
	        return new MyUserDetails(user);
	}
	

	
}
