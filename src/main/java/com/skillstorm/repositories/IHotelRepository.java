package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer>{
	
	List<Hotel> findAllByLocationId(int locationId);

}
