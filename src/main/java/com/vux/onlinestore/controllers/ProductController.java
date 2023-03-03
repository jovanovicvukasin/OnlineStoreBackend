package com.vux.onlinestore.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vux.onlinestore.dto.ProductDTO;
import com.vux.onlinestore.entity.Product;
import com.vux.onlinestore.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		List<Product> products = productService.findAll();
		//convert products to DTOs
		List<ProductDTO> productsDTO = new ArrayList<>();
		for(Product p : products) {
			productsDTO.add(new ProductDTO(p));
		}
		return new ResponseEntity<>(productsDTO, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> productsPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		
		List<Product> products = new ArrayList<>();
		Pageable paging = PageRequest.of(page, size);
		
		Page<Product> pageP = productService.findAll(paging);
		products = pageP.getContent();
		
		List<ProductDTO> productsDTO = new ArrayList<>();
		for(Product p: products) {
			productsDTO.add(new ProductDTO(p));
		}
		
		Map<String, Object> response = new HashMap<>();
		response.put("products", productsDTO);
		response.put("currentPage", pageP.getNumber());
		response.put("totalItems", pageP.getTotalElements());
		response.put("totalPages", pageP.getTotalPages());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDTO> getById(@PathVariable Long productId){
		Product product = productService.findById(productId);
		if(product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ProductDTO(product), HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) throws IOException{
				
		Product productName = productService.findByName(productDTO.getName());
		
		if(productName != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setCategory(productDTO.getCategory());
		product.setAvailability(productDTO.isAvailability());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setActive(true);
				
		product = productService.save(product);


		return new ResponseEntity<>(new ProductDTO(product),  HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){
		//product must exist
		Product product = productService.findById(id);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		product.setName(productDTO.getName());
		product.setCategory(productDTO.getCategory());
		product.setAvailability(productDTO.isAvailability());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setActive(productDTO.isActive());
		
		product = productService.save(product);
		return new ResponseEntity<>(new ProductDTO(product), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long id){
		
		Product product = productService.findById(id);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		product.setActive(false);
		
		product = productService.save(product);
		return new ResponseEntity<>(new ProductDTO(product), HttpStatus.OK);
		
	}
	
	
}
