package com.vux.onlinestore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vux.onlinestore.entity.AcceptedOrders;
import com.vux.onlinestore.repository.AcceptedOrdersRepository;
import com.vux.onlinestore.services.interfaces.AcceptedOrdersServiceInterface;

@Service
public class AcceptedOrdersService implements AcceptedOrdersServiceInterface {

	@Autowired
	AcceptedOrdersRepository acceptedOrdersRepository;
	
	@Override
	public AcceptedOrders findById(Long id) {
		return acceptedOrdersRepository.findById(id).orElse(null);
	}

	@Override
	public AcceptedOrders save(AcceptedOrders acceptedOrders) {
		return acceptedOrdersRepository.save(acceptedOrders);
	}

}
