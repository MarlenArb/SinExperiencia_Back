package com.sinexperiencia.sinexperiencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinexperiencia.sinexperiencia.dtos.UserDto;
import com.sinexperiencia.sinexperiencia.services.impl.UserServiceImpl;


@RestController
@RequestMapping("/user")
@CrossOrigin( methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
public class UserController {

	
	@Autowired
	private UserServiceImpl userService;
	
	// GET
	@GetMapping("/{id}")
	public UserDto getUser(@Validated @PathVariable Long id) {
		return userService.getUser(id);
	}
	
	//CARGA INICIAL
	@PostMapping("/loadUsers")
	public void loadUsers(@Validated @RequestBody List<UserDto> users) {
		userService.loadUsers(users);
	};
	
	
	@GetMapping("/checkUser/{userName}")
	public UserDto getUserByUsername(@Validated @PathVariable String userName) {
		return userService.getUserByUserName(userName);
	}

	// POST
	@PostMapping
	public void addUser(@Validated @RequestBody UserDto user) {
		userService.addUser(user);
	};

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	// GET
	@GetMapping
	public List<UserDto> getUsers() {
		return userService.getUsers();
	}

	// PUT
	@PutMapping("/{id}")
	public UserDto modifyUser(@Validated @PathVariable Long id, @Validated @RequestBody UserDto user) {
		return userService.modifyUser(id, user);
	}

}
