package com.swarna.boot.SpringJwtApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swarna.boot.SpringJwtApp.model.AuthRequest;
import com.swarna.boot.SpringJwtApp.util.JwtUtil;

@RestController
public class WelcomeController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/login")
	public String welcome() {
		return "You are Authenticated !!!";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		} catch (InvalidAuthenticationException e){
			throw new Exception("Anyone of Username / password is wrong");
		} catch (Exception e) {
			throw new Exception("Invalid Username or password");
		}

		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
