package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable long id) {
		return userRepository.findById(id);
	}

	@GetMapping("/users/search")
	public List<User> getUserByName(@RequestParam String name) {
		return userRepository.findByNameContaining(name);
	}

	@PostMapping("/users")
	public String addUser(@RequestBody User u) {
		userRepository.save(u);
		return "User has been added!!";
	}
	

}
