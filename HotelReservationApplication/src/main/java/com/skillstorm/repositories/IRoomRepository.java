package com.skillstorm.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Room;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Integer> {

	List<Room> findAllByHotelHotelId(int hotelId);
}
