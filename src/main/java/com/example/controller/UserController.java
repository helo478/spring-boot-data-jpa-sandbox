package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.model.UserList;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public UserList getUsers() {

		return userService.readUsers();
	}

	@GetMapping("/{guid}")
	public User getUser(final @PathVariable("guid") String guid) {
		return userService.readUser(guid);
	}

	@PostMapping()
	public User postUser(final @RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{guid}")
	public void putUser(final @PathVariable("guid") String guid, final @RequestBody User user) {
		userService.updateUser(guid, user);
	}
	
	@DeleteMapping("/{guid}")
	public boolean deleteUser(final @PathVariable("guid") String guid) {
		return userService.deleteUser(guid);
	}

}