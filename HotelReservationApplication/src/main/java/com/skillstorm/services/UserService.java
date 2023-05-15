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
		// TODO Auto-generated method stub
		return null;
	}

	public UserDto getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow()
				.toDto();
	}

	public UserDto createUser(@Valid UserDto userData) {
		User user = new User(userData.getId(),userData.getFirstName(), userData.getLastName(), userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getPhoneNumber());
		return userRepository.save(user).toDto();
	}

	public UserDto updateUser(UserDto userData) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		
	}
	

}
