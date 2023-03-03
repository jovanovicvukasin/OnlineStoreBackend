package com.vux.onlinestore.dto;

import com.vux.onlinestore.entity.AcceptedOrders;

public class AcceptedOrdersDTO {

	private Long id;
	private ProductDTO product;
	private OrderDTO order;
	
	public AcceptedOrdersDTO() {
		
	}
	
	public AcceptedOrdersDTO(Long id, ProductDTO product, OrderDTO order) {
		super();
		this.id = id;
		this.product = product;
		this.order = order;
	}
	
	public AcceptedOrdersDTO(AcceptedOrders acceptedOrders) {
		id = acceptedOrders.getId();
		product = new ProductDTO(acceptedOrders.getProduct());
		order = new OrderDTO(acceptedOrders.getOrder());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}
	
}
