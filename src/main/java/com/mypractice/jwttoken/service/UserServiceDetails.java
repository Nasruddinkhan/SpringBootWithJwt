package com.mypractice.jwttoken.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mypractice.jwttoken.bean.MyUserDetails;
import com.mypractice.jwttoken.modal.Users;
import com.mypractice.jwttoken.repo.UserRepository;

/**
 * Nasruddin khan
 * UserServiceDetails.java
 * Dec 12, 2019 8:02:22 PM
 */
@Service
public class UserServiceDetails implements UserDetailsService{
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> users=	userRepo.findByUsername(username);
		users.orElseThrow(()->
		new  UsernameNotFoundException(username+" :: is not found"));
		return  users.map(MyUserDetails::new).get();
	}

}
