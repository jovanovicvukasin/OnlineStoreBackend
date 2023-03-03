package com.vux.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vux.onlinestore.entity.AcceptedOrders;

@Repository
public interface AcceptedOrdersRepository extends JpaRepository<AcceptedOrders, Long> {

}
