package com.vux.onlinestore.services.interfaces;

import com.vux.onlinestore.dto.UserDTO;
import com.vux.onlinestore.entity.User;

public interface UserServiceInterface {

	public User findOne(Integer id);
	
	public User save(UserDTO user);
	
	public User findByUsername(String username);
}
