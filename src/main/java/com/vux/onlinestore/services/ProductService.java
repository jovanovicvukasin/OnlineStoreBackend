package com.vux.onlinestore.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vux.onlinestore.entity.Product;
import com.vux.onlinestore.repository.ProductRepository;
import com.vux.onlinestore.services.interfaces.ProductServiceInterface;


@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(id);
		return product.orElse(null);
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findByName(name);
		return product.orElse(null);
	}

	@Override
	public Page<Product> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return productRepository.findAll(page);
	}
	
}
