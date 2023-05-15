package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Amenities;

@Repository
public interface IAmenitiesRepository extends JpaRepository<Amenities, Integer>{

}
