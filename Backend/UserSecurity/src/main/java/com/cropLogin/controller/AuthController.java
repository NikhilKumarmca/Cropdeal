package com.cropLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.cropLogin.model.AuthenticationRequest;
import com.cropLogin.model.AuthenticationResponse;
import com.cropLogin.model.UserModel;
import com.cropLogin.repository.UserRepository;
import com.cropLogin.services.UserServices;
import com.cropLogin.utils.JwtUtils;

@RestController
@CrossOrigin
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping("/welcome")
	public String testingToken() {
		return "Welcome to DASHBOARD "+ SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	//to add new user
	@PostMapping("/authreg")
	public ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		String username=authenticationRequest.getEmail();
		String password=authenticationRequest.getPassword();
		UserModel userModel=new UserModel();
		userModel.setEmail(username);
		userModel.setPassword(password);
		try {
			userRepository.save(userModel);
		}
		catch(Exception e) {
			throw new Exception("Invalid",e);
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful subscription for client "+ username));
		
	}
	
	//to authenticate existing user
	@PostMapping("/auth")
    public ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		String username=authenticationRequest.getEmail();
		String password=authenticationRequest.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(Exception e) {
			throw new Exception("Invalid",e);



		}
		UserDetails loadeduser=userServices.loadUserByUsername(username);
		String generatedToken=jwtUtils.generateToken(loadeduser);
		
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));

	}
	

}
