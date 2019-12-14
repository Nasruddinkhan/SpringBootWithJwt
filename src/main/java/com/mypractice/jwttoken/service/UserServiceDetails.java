package com.mypractice.jwttoken.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Nasruddin khan
 * UserServiceDetails.java
 * Dec 12, 2019 8:02:22 PM
 */
@Service
public class UserServiceDetails implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new User("nasru", "nasru", new ArrayList<>());
	}

}
