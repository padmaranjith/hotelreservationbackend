package com.skillstorm.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skillstorm.models.User;
import com.skillstorm.dtos.UserDto;
import com.skillstorm.repositories.IUserRepository;

@Service
public class UserService implements UserDetailsService{
	@Autowired
    private IUserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
		//User user = new User(userData.getUserId(),userData.getFirstName(), userData.getLastName(), userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getPhoneNumber());
		//return userRepository.save(user).toDto();
		Optional<User> foundUser=userRepository.findByUsername(userData.getUsername());
		
		//If user with the username already exists
		if(foundUser.isPresent()) {
			System.out.println("User name already taken");
			throw new RuntimeException("Username is already taken");
		}else {
			System.out.println("Creating user..");
			String password=passwordEncoder.encode(userData.getPassword());
			User user = new User(userData.getUserId(),userData.getFirstName(), userData.getLastName(), userData.getUsername(),password,userData.getEmail(),userData.getPhoneNumber());
			return userRepository.save(user).toDto();
		}
	}

	public UserDto updateUser(UserDto userData) {
		User user = new User(userData.getUserId(),userData.getFirstName(), userData.getLastName(), userData.getUsername(),userData.getPassword(),userData.getEmail(),userData.getPhoneNumber());
		return userRepository.save(user).toDto();
	}

	public void deleteUser(long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userRepository.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException(username + "not found."));
		return user;
	}
	
	public void register(User user) {
		Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
		
		if (foundUser.isPresent()) {
			throw new RuntimeException("The username is already taken, please try another one");
		}
		userRepository.save(user); 
	}

	public UserDto signInUser(String username, String password) {
		// Check if the user exists
		User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // Validate the password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        return user.toDto();
	}
	
	

}
