package com.vux.onlinestore.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {
	
	public enum Category { BAKING, BREAD_AND_BAKERY, DELI, DRINKS, FROZEN_FOODS, OTHER, PASTA_AND_RICE, PERSONAL_CARE, SNACKS };
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", columnDefinition = "VARCHAR(50)", unique = true, nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name = "price", columnDefinition = "DOUBLE", nullable = false)
	private Double price;
	
	@Column(name = "availability", nullable = false)
	private Boolean availability;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "photo_id", referencedColumnName = "id")
	private ProductPhoto productPhoto;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "active", nullable = false)
	private Boolean active;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<AcceptedOrders> acceptedOrders = new HashSet<AcceptedOrders>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductPhoto getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(ProductPhoto productPhoto) {
		this.productPhoto = productPhoto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<AcceptedOrders> getAcceptedOrders() {
		return acceptedOrders;
	}

	public void setAcceptedOrders(Set<AcceptedOrders> acceptedOrders) {
		this.acceptedOrders = acceptedOrders;
	}
	
	
	
	
	
}
