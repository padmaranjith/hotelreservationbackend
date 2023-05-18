package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Location;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Integer> {

	@Query(value = "SELECT * FROM locations " +
            "WHERE LOWER(REPLACE(city, ' ', '')) ILIKE LOWER(REPLACE(concat('%', :locationName, '%'), ' ', '')) OR " +
            "LOWER(REPLACE(state_province, ' ', '')) ILIKE LOWER(REPLACE(concat('%', :locationName, '%'), ' ', '')) OR " +
            "LOWER(REPLACE(country, ' ', '')) ILIKE LOWER(REPLACE(concat('%', :locationName, '%'), ' ', ''))",
    nativeQuery = true)
	Location getLocationByLocationName(@Param("locationName") String locationName);
}

