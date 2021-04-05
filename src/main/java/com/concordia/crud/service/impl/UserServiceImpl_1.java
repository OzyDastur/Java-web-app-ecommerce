//package com.concordia.crud.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.concordia.crud.dto.UserDTO;
//import com.concordia.crud.model.User;
//import com.concordia.crud.repository.UserRepository;
//import com.concordia.crud.service.UserService;
//import com.github.dozermapper.core.DozerBeanMapperBuilder;
//
///**
// * User Service Implementation
// *
// * @author Alexis
// *
// */
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDTO getUser(Long id) {
//		Optional<User> optional = userRepository.findById(id);
//		User user = null;
//		if (optional.isPresent()) {
//			user = optional.get();
//		} else {
//			throw new RuntimeException("User not found for id : " + id);
//		}
//
//		return userToUserDTO(user);
//	}
//
//	@Override
//	@Transactional
//	public void saveUser(UserDTO userDTO) {
//
//		User user = new User();
//		user.setId(user.getId());
//		user.setFirstName(userDTO.getFirstName());
//		user.setLastName(userDTO.getLastName());
//		user.setEmailAddress(userDTO.getEmail());
//		user.setMobileNumber(userDTO.getMobile());
//		user.setPassword(userDTO.getPassword());
//		user.setUserLastLogin(userDTO.getLastLogin());
//		user.setUserProfile(userDTO.getProfile());
//		userRepository.save(user);
//	}
//
//	@Override
//	@Transactional
//	public void deleteUser(Long id) {
//
//		userRepository.deleteById(id);
//	}
//
//	@Override
//	@Transactional
//	public void updateUser(UserDTO userDTO) {
//		Optional<User> optional = userRepository.findById(userDTO.getId());
//		User user = null;
//		if (optional.isPresent()) {
//			user = optional.get();
//		} else {
//			throw new RuntimeException("User not found for id : " + userDTO.getId());
//		}
//		user.setId(user.getId());
//		user.setFirstName(userDTO.getFirstName());
//		user.setLastName(userDTO.getLastName());
//		user.setEmailAddress(userDTO.getEmail());
//		user.setMobileNumber(userDTO.getMobile());
//		user.setPassword(userDTO.getPassword());
//		user.setUserLastLogin(userDTO.getLastLogin());
//		user.setUserProfile(userDTO.getProfile());
//		userRepository.save(user);
//	}
//
//	@Override
//	public List<UserDTO> getAllUsers() {
//		List<User> users = this.userRepository.findAll();
//
//		List<UserDTO> userDTOs = new ArrayList<UserDTO>(users.size());
//		for (User user : users) {
//			userDTOs.add(userToUserDTO(user));
//		}
//
//		return userDTOs;
//	}
//
//	@Override
//	public Page<UserDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
//		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
//				: Sort.by(sortField).descending();
//
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
//
//		Page<UserDTO> userDTOs = this.userRepository.findAll(pageable)
//				.map((user -> DozerBeanMapperBuilder.buildDefault().map(user, UserDTO.class)));
//
//		return userDTOs;
//	}
//
//	private UserDTO userToUserDTO(User user) {
//
//		if (user == null) {
//			return null;
//		}
//
//		UserDTO userDTO = new UserDTO();
//		userDTO.setId(user.getId());
//		userDTO.setFirstName(user.getFirstName());
//		userDTO.setLastName(user.getLastName());
//		userDTO.setEmail(user.getEmailAddress());
//		userDTO.setMobile(user.getMobileNumber());
//		userDTO.setPassword(user.getPassword());
//		userDTO.setLastLogin(user.getUserLastLogin());
//		userDTO.setProfile(user.getUserProfile());
//
//		return userDTO;
//	}
//}
