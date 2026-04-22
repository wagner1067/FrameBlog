package com.blog.FrameBlog.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.blog.FrameBlog.models.User;
import com.blog.FrameBlog.repositories.UserRepository;
import com.blog.FrameBlog.request.AuthRequest;
import com.blog.FrameBlog.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return userRepository.findByUsername(login);
	}
	
	@Override
	public String getToken(AuthRequest auth) {
		User user = userRepository.findByUsername(auth.getUsername());
		return generateToken(user);
	}
	
	public String generateToken(User user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("my-secret");
			
			return JWT.create()
					.withIssuer("FrameBlog")
					.withSubject(user.getUsername())
					.withExpiresAt(getEspirantionDate())
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Failed to generate token" + exception.getMessage());
		}
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("my-secret");
			
			return JWT.require(algorithm)
					.withIssuer("FrameBlog")
					.build()
					.verify(token)
					.getSubject();
		} catch (JWTVerificationException exception) {
			return "";
		}
	}
	
	private Instant getEspirantionDate() {
		return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
	}
}
