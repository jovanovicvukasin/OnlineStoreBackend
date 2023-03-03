package com.vux.onlinestore.dto;

import java.time.LocalDate;

import com.vux.onlinestore.entity.Roles;
import com.vux.onlinestore.entity.User;

public class UserDTO {

	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String role;
	
	public UserDTO() {
	}
	
	public UserDTO(User user) {
		id = user.getId();
		username = user.getUsername();
		//password = user.getPassword();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		birthDate = user.getBirthDate();
		role = user.getRole().toString();
	}
	
	public UserDTO(Integer id, String username, String firstName, String lastName,
			LocalDate birthDate, String role) {
		super();
		this.id = id;
		this.username = username;
		//this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
