package com.vux.onlinestore.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vux.onlinestore.dto.AcceptedOrdersDTO;
import com.vux.onlinestore.dto.OrderDTO;
import com.vux.onlinestore.dto.ProductDTO;
import com.vux.onlinestore.entity.AcceptedOrders;
import com.vux.onlinestore.entity.Order;
import com.vux.onlinestore.entity.User;
import com.vux.onlinestore.services.OrderService;
import com.vux.onlinestore.services.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		List<Order> orders = orderService.findAll();
		List<OrderDTO> ordersDTO = new ArrayList<>();
		for(Order o : orders) {
			ordersDTO.add(new OrderDTO(o));
		}
		
		return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}/products")
	public ResponseEntity<List<AcceptedOrdersDTO>> getOrderProducts(@PathVariable Integer orderId) {
		Order order = orderService.findById(orderId);
		Set<AcceptedOrders> acceptedOrders = order.getAcceptedOrders();
		List<AcceptedOrdersDTO> aoDTOs = new ArrayList<>();
		for(AcceptedOrders ao: acceptedOrders) {
			AcceptedOrdersDTO aoDTO = new AcceptedOrdersDTO();
			aoDTO.setId(ao.getId());
			aoDTO.setOrder(new OrderDTO(ao.getOrder()));
			aoDTO.setProduct(new ProductDTO(ao.getProduct()));
			
			aoDTOs.add(aoDTO);
		}
		return new ResponseEntity<>(aoDTOs, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDto){
		
		User user = userService.findByUsername(orderDto.getUser().getUsername());
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Order order = new Order();
		order.setDateAndTime(LocalDateTime.now());
		order.setUser(user);
		
		order = orderService.save(order);
		
		return new ResponseEntity<>(new OrderDTO(order), HttpStatus.CREATED);
	}
	
}
