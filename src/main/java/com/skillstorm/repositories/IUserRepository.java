package com.skillstorm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	Optional<User> findById(long userId);

	//To check whether user name exists already for authentication
	Optional<User> findByUsername(String username);

}
