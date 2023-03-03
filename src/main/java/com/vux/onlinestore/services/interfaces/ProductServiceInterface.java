package com.vux.onlinestore.services.interfaces;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.vux.onlinestore.entity.Product;

public interface ProductServiceInterface {

	List<Product> findAll();
	Product findById(Long id);
	Product save(Product product);
	Product findByName(String name);
	Page<Product> findAll(Pageable page);
}
