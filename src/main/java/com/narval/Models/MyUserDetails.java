package com.narval.Models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Usuario user;
	     
	public MyUserDetails(Usuario user) {
		this.user= user;
	}
	 

	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	public String getEmail() {
		return user.getEmail();
	}

	public String getName() {
		return user.getName();
	}
	@Override
	public String getPassword() {
		return user.getHashed_password();
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
