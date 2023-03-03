package com.vux.onlinestore.dto;

import java.time.LocalDateTime;

import com.vux.onlinestore.entity.Order;

public class OrderDTO {
	
	private Integer id;
	private UserDTO user;
	private LocalDateTime dateTime;
	
	public OrderDTO() {
		
	}
	
	public OrderDTO(Integer id, UserDTO user, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.user = user;
		this.dateTime = dateTime;
	}

	public OrderDTO(Order order) {
		id = order.getId();
		user = new UserDTO(order.getUser());
		dateTime = order.getDateAndTime();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
