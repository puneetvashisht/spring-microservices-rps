package com.fis.authservice.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fis.authservice.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
	
	@Value("${jwt.secret}")
	private String jwtSecret;

//	@Value("${jwt.token.validity}")
//	private long tokenValidity;

//	public Claims getClaims(final String token) {
//		try {
//			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//			return body;
//		} catch (Exception e) {
//			System.out.println(e.getMessage() + " => " + e);
//		}
//		return null;
//	}
//
//	public String generateToken(String id) {
//		Claims claims = Jwts.claims().setSubject(id);
//		long nowMillis = System.currentTimeMillis();
//		long expMillis = nowMillis + tokenValidity;
//		Date exp = new Date(expMillis);
//		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
//				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//	}
	
	public String generateToken(User user) {
		return Jwts.builder()
				.setSubject(user.getUsername())
				.signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
	}
	
//	public String generateJwtToken(String id) {
//		return Jwts.builder().claim(id, id)
////				.setSubject(id)
////				.claim("Roles", (userPrincipal.getAuthorities())
////						.stream()
////						.map(item -> item.getAuthority())
////						.collect(Collectors.toList())
////						)
////				.claim("userId",userPrincipal.getId())
////				.setIssuedAt(new Date())
////				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
////				.signWith(SignatureAlgorithm.HS512, jwtSecret)
////				.compact();
////	}

//	public boolean validateToken(String authToken) {
//		try {
//			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//			return true;
//		} catch (SignatureException e) {
//			logger.error("Invalid JWT signature: {}", e.getMessage());
//		} catch (MalformedJwtException e) {
//			logger.error("Invalid JWT token: {}", e.getMessage());
//		} catch (ExpiredJwtException e) {
//			logger.error("JWT token is expired: {}", e.getMessage());
//		} catch (UnsupportedJwtException e) {
//			logger.error("JWT token is unsupported: {}", e.getMessage());
//		} catch (IllegalArgumentException e) {
//			logger.error("JWT claims string is empty: {}", e.getMessage());
//		}
//
//		return false;
//	}

}
