package com.example.demo.Repository;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByNameContaining(String keyword);
}
