package com.vux.onlinestore.services.interfaces;

import java.util.List;

import com.vux.onlinestore.entity.Order;

public interface OrderServiceInterface {

	List<Order> findAll();
	Order findById(Integer id);
	Order save(Order order);


}
