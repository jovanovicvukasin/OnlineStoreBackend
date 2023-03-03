package com.vux.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vux.onlinestore.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
