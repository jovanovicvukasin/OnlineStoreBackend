package com.vux.onlinestore.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.onlinestore.entity.Order;
import com.vux.onlinestore.repository.OrderRepository;
import com.vux.onlinestore.services.interfaces.OrderServiceInterface;

@Service
public class OrderService implements OrderServiceInterface {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(Integer id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.orElse(null);
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

}
