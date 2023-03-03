package com.vux.onlinestore.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private User user; 
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<AcceptedOrders> acceptedOrders = new HashSet<AcceptedOrders>();
	
	@Column(name = "dateAndTime", nullable = false)
	private LocalDateTime dateAndTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<AcceptedOrders> getAcceptedOrders() {
		return acceptedOrders;
	}

	public void setAcceptedOrders(Set<AcceptedOrders> acceptedOrders) {
		this.acceptedOrders = acceptedOrders;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	

	
}
