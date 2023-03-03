package com.vux.onlinestore.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.onlinestore.dto.OrderDTO;
import com.vux.onlinestore.dto.UserDTO;
import com.vux.onlinestore.entity.Order;
import com.vux.onlinestore.entity.User;
import com.vux.onlinestore.security.TokenUtils;
import com.vux.onlinestore.services.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@GetMapping("/{userId}/orders")
	public ResponseEntity<List<OrderDTO>> getUserOrders (@PathVariable Integer userId) {
		
		User user = userService.findOne(userId);
		Set<Order> orders = user.getOrders();
		List<OrderDTO> ordersDTO = new ArrayList<>();
		for(Order o: orders) {
			ordersDTO.add(new OrderDTO(o));
		}
		return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
		User user = userService.findByUsername(username);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
	}
	
	@PostMapping("/registration")
	public ResponseEntity<UserDTO> registration(@RequestBody @Validated UserDTO newUser){
		
		User createdUser = userService.save(newUser);
		
		if(createdUser == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		}
		
		UserDTO userDTO = new UserDTO(createdUser);
		
		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
			String token = tokenUtils.generateToken(userDetails);
			System.out.println("token (login): " + token);
			return ResponseEntity.ok(token);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
