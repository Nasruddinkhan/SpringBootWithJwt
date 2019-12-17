package com.mypractice.jwttoken.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mypractice.jwttoken.service.UserServiceDetails;

/**
 * Nasruddin khan
 * JwtRequestFilter.java
 * Dec 12, 2019 9:43:03 PM
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private UserServiceDetails userServiceDetails;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authorization=	request.getHeader("Authorization");
		String 	userName = null;
		String jwtToken = null;
		if(authorization != null && authorization.startsWith("myToken ")) {
			jwtToken = authorization.substring(8);
			userName = jwtUtil.extractUserName(jwtToken);
		}
		if(userName !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails  =this.userServiceDetails.loadUserByUsername(userName);
			if(jwtUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				passwordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
