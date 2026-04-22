package com.blog.FrameBlog.services;

import com.blog.FrameBlog.request.AuthRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticationService extends UserDetailsService {
	
	String getToken(AuthRequest auth);
	
	String validateToken(String token);
}
