package com.concordia.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concordia.crud.dto.UserDTO;
import com.concordia.crud.model.User;
import com.concordia.crud.repository.UserRepository;
import com.concordia.crud.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(UserDTO userDTO) {
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setMobileNumber(userDTO.getMobile());
		user.setEmailAddress(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		
		userRepository.save(user);
		
	}

}
