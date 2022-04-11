package com.cropLogin.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cropLogin.model.UserModel;
import com.cropLogin.repository.UserRepository;

@Service  
public class UserServices implements UserDetailsService{ 
    
	@Autowired
	private UserRepository userRepository;
	

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userfound=userRepository.findByEmail(username);
		if(userfound==null) {
			return null;
		}
		
		String email=userfound.getEmail();
		String pswd=userfound.getPassword();
		
		
		return new User(email,pswd,new ArrayList<>());
	}  

}
