package com.vux.onlinestore.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vux.onlinestore.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
}
