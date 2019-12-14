package com.mypractice.jwttoken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Nasruddin khan
 * UserController.java
 * Dec 12, 2019 10:11:07 PM
 */
@RestController
public class UserController {

	@GetMapping("/hello")
	public String getHello() {
		return "Hello ";
		
	}
}
