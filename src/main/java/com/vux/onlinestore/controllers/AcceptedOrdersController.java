package com.vux.onlinestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.onlinestore.dto.AcceptedOrdersDTO;
import com.vux.onlinestore.entity.AcceptedOrders;
import com.vux.onlinestore.entity.Order;
import com.vux.onlinestore.entity.Product;
import com.vux.onlinestore.services.AcceptedOrdersService;
import com.vux.onlinestore.services.OrderService;
import com.vux.onlinestore.services.ProductService;

@RestController
@RequestMapping("/api/accepted")
public class AcceptedOrdersController {
	
	@Autowired
	AcceptedOrdersService acceptedOrdersService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public ResponseEntity<AcceptedOrdersDTO> saveProductsForOrders(@RequestBody AcceptedOrdersDTO acceptedOrdersDto) {
		
		if(acceptedOrdersDto.getOrder() == null || acceptedOrdersDto.getProduct() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Order order = orderService.findById(acceptedOrdersDto.getOrder().getId());
		Product product = productService.findById(acceptedOrdersDto.getProduct().getId());
		
		if(order == null || product == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		AcceptedOrders ac = new AcceptedOrders();
		ac.setOrder(order);
		ac.setProduct(product);
		
		ac = acceptedOrdersService.save(ac);
			
		return new ResponseEntity<>(new AcceptedOrdersDTO(ac), HttpStatus.CREATED);
	}

}
