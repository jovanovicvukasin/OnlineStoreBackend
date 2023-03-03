package com.vux.onlinestore.dto;

import com.vux.onlinestore.entity.Product;
import com.vux.onlinestore.entity.Product.Category;
import com.vux.onlinestore.entity.ProductPhoto;

public class ProductDTO {
	
	private long id;
	private String name;
	private Category category;
	private String description;
	private boolean availability;
	private boolean active;
	private ProductPhoto productPhoto;
	private double price;
	
	public ProductDTO() {
	}
	
	public ProductDTO(Product product) {
		id = product.getId();
		name = product.getName();
		category = product.getCategory();
		description = product.getDescription();
		availability = product.getAvailability();
		active = product.getActive();
		productPhoto = product.getProductPhoto();
		price = product.getPrice();
	}
	
	public ProductDTO(long id, String name, Category category, String description, boolean availability, boolean active,
			ProductPhoto productPhoto, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.availability = availability;
		this.active = active;
		this.productPhoto = productPhoto;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ProductPhoto getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(ProductPhoto productPhoto) {
		this.productPhoto = productPhoto;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
