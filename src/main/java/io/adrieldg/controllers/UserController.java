package io.adrieldg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.adrieldg.entities.User;
import io.adrieldg.repositories.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepositry) {
		this.userRepository = userRepositry;
	}

	@RequestMapping(method = RequestMethod.GET)
	Iterable<User> readUsers() {
		return this.userRepository.findAll();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	User read(@PathVariable Long userId) {
		return this.userRepository.findOne(userId);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	String update(@PathVariable Long userId, User entity) {
		return "";
	}

}
