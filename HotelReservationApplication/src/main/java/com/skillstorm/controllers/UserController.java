package com.skillstorm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.UserDto;
import com.skillstorm.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
	
	@GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
	
	@PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userData) {
        UserDto user = userService.createUser(userData);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
	public UserDto updateUser(@PathVariable long id, @RequestBody UserDto userData) {
		userData.setId(id);
		return userService.updateUser(userData);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}
	
	

}
