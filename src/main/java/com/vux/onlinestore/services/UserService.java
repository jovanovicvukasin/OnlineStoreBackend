package com.vux.onlinestore.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vux.onlinestore.dto.UserDTO;
import com.vux.onlinestore.entity.Roles;
import com.vux.onlinestore.entity.User;
import com.vux.onlinestore.repository.UserRepository;
import com.vux.onlinestore.services.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder psswordEncoder;
	
	@Override
	public User findOne(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User save(UserDTO userDTO) {
		
		Optional<User> user = userRepository.findByUsername(userDTO.getUsername());
		
		if(user.isPresent()) {
			return null;
		}
		
		User newUser = new User();
		newUser.setUsername(userDTO.getUsername());
		newUser.setPassword(psswordEncoder.encode(userDTO.getPassword()));
		newUser.setFirstName(userDTO.getFirstName());
		newUser.setLastName(userDTO.getLastName());
		newUser.setBirthDate(userDTO.getBirthDate());
		newUser.setRole(Roles.USER);
		
		newUser = userRepository.save(newUser);
		
		return newUser;
	}

	@Override
	public User findByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		
		return user.orElse(null);
	}
	
	
}
