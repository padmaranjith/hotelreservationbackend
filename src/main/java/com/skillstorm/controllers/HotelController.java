package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.HotelDto;
import com.skillstorm.dtos.RoomDto;
import com.skillstorm.dtos.UserDto;
import com.skillstorm.models.Amenities;
import com.skillstorm.models.Hotel;
import com.skillstorm.repositories.IHotelRepository;
import com.skillstorm.services.HotelService;

@RestController
@CrossOrigin
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	@GetMapping("/hotels")
	public List<HotelDto> getAllHotels(){
		return hotelService.getAllHotels();
	}
	
	@GetMapping("hotels/{locationName}")
	public List<HotelDto> getHotelsByLocation(@PathVariable String locationName){
		return hotelService.getHotelsByLocation(locationName);
	}

	@GetMapping("hotels/{hotelId}/amenities")
	public List<Amenities> getAllAmenitiesInHotel(@PathVariable("hotelId") int hotelId){
		return hotelService.getAllAmenitiesInHotel(hotelId);
	} 
	
	
	
	
}
