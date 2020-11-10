package com.narval.Services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.narval.repository.TokenRepository;

import com.narval.Models.Token;
import com.narval.Models.Usuario;

@Service
public class TokenService {

	TokenRepository tokenRepository;
	
	public Token addToken(Usuario user) {
		
		Token token = new Token();
		token.setUserId(user);
		token.setExpirationTime(new Date());
		token.setActive(true);
		
		tokenRepository.save(token);
		
		return token;
	}
}
