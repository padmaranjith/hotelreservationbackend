package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer>{

}
