package com.skillstorm.controllers;

import java.util.List;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.skillstorm.dtos.SignInRequest;
import com.skillstorm.dtos.UserDto;
import com.skillstorm.models.User;
import com.skillstorm.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
	
	@GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable long userId) {
        return userService.getUserByUserId(userId);
    }
	
	@PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userData) {
        try {
        	UserDto user = userService.createUser(userData);
        	return new ResponseEntity<>(user, HttpStatus.CREATED);
        	} catch (RuntimeException e) {
        	  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        	}
}
	@PutMapping("/{userId}")
	public UserDto updateUser(@PathVariable long userId, @RequestBody UserDto userData) {
		userData.setUserId(userId);
		return userService.updateUser(userData);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable long userId) {
		userService.deleteUser(userId);
	}

	@PostMapping("/signin")
    public ResponseEntity<UserDto> signInUser(@RequestBody SignInRequest signInRequest) {
        try {
            UserDto user = userService.signInUser(signInRequest.getUsername(), signInRequest.getPassword());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
