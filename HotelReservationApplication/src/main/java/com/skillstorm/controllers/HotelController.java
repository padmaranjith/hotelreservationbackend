package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.HotelDto;
import com.skillstorm.dtos.RoomDto;
import com.skillstorm.dtos.UserDto;
import com.skillstorm.services.HotelService;

@RestController
@CrossOrigin
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/hotels")
	public List<HotelDto> getAllHotels(){
		return hotelService.getAllHotels();
	}
	
	@GetMapping("hotels/{locationName}")
	public List<HotelDto> getHotelsByLocation(@PathVariable String locationName){
		return hotelService.getHotelsByLocation(locationName);
	}

}
