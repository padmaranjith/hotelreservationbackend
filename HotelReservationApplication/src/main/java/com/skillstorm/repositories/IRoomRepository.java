package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Room;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Integer> {

}
