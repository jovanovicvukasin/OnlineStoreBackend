package com.vux.onlinestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.onlinestore.entity.ProductPhoto;

public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Long> {

	Optional<ProductPhoto> findByName(String name);
}
