package com.narval.Services;

import java.util.Date;

import com.narval.repository.TokenRepository;

import com.narval.Models.Token;
import com.narval.Models.Usuario;

public class TokenService {

	TokenRepository tokenRepository;
public Token addToken(Usuario user) {
		
		Token token = new Token();
		token.setUserId(user.getId());
		token.setExpirationTime(new Date());
		token.setActive(true);
		
		tokenRepository.save(token);
		
		return token;
	}
}
