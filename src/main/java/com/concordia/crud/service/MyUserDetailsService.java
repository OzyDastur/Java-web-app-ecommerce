package com.concordia.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.concordia.crud.model.User;
import com.concordia.crud.model.UserPrincipal;
import com.concordia.crud.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		//Create a new User 
		User user = userRepository.findByEmailAddress(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		
		return new UserPrincipal(user);
	}

}
