package com.vux.onlinestore.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vux.onlinestore.entity.Product;
import com.vux.onlinestore.entity.ProductPhoto;
import com.vux.onlinestore.repository.ProductPhotoRepository;
import com.vux.onlinestore.services.ProductService;

@RestController
@RequestMapping("/api/photo")
public class ProductPhotoController {

	
	@Autowired
	ProductPhotoRepository productPhotoRepository;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/upload/{productId}")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable Long productId) throws IOException {
		
		System.out.println("Original Image Byte Size :" + file.getBytes().length);
		
		ProductPhoto image = new ProductPhoto(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
		productPhotoRepository.save(image);
		
		Product product = productService.findById(productId);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		product.setProductPhoto(image);
		productService.save(product);
		
		
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);		
		
		return outputStream.toByteArray();
	}
	
}
