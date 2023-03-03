package com.vux.onlinestore.services.interfaces;

import com.vux.onlinestore.entity.AcceptedOrders;

public interface AcceptedOrdersServiceInterface {

	AcceptedOrders findById(Long id);
	
	AcceptedOrders save(AcceptedOrders acceptedOrders);
	
}
