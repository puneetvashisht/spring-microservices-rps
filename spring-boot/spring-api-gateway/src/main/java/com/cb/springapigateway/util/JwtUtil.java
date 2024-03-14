package com.cb.springapigateway.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

}
