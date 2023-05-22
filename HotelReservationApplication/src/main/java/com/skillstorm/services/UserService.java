package com.skillstorm.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.User;
import com.skillstorm.dtos.UserDto;
import com.skillstorm.repositories.IUserRepository;

@Service
public class UserService {
	@Autowired
    private IUserRepository userRepository;

	public List<UserDto> getAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(user->user.toDto())
				.toList();
	}
	
	public UserDto getUserByUserId(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow()
				.toDto();
	}

	public UserDto createUser(@Valid UserDto userData) {
		User user = new User(userData.getUserId(),userData.getFirstName(), userData.getLastName(), userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getPhoneNumber());
		return userRepository.save(user).toDto();
	}

	public UserDto updateUser(UserDto userData) {
		User user = new User(userData.getUserId(),userData.getFirstName(), userData.getLastName(), userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getPhoneNumber());
		return userRepository.save(user).toDto();
	}

	public void deleteUser(long userId) {
		userRepository.deleteById(userId);
		
	}
	

}
