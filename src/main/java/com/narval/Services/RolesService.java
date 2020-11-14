package com.narval.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.narval.Models.Roles;
import com.narval.repository.RolesRepository;
import com.narval.repository.UserRepository;

@Service
public class RolesService {
	@Autowired
	 RolesRepository rolesRepository;
	
	public List<String> getNames(){
		List<Roles> roles=(List<Roles>) rolesRepository.findAll();
		List<String> nombres=new ArrayList<String>();
		for(int i=0; i<roles.size();i++) {
			nombres.add(roles.get(i).getName());
		}
		
		return nombres;
	}
}	
