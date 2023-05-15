package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.HotelDto;
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
}
