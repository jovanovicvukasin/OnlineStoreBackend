package com.vux.onlinestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vux.onlinestore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
		
	Optional<Product> findById(Long id);
	Optional<Product> findByName(String name);
}
