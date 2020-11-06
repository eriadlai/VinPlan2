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
		
		System.out.println("holasi"+username);
		Optional<Usuario> user = userRepository.findByEmail(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + username));
		System.out.println(user.get().getHashed_password());
		return user.map(MyUserDetails::new).get();
	}
	
}
