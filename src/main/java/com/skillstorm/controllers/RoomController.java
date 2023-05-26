package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.RoomDto;
import com.skillstorm.services.RoomService;

@RestController
@CrossOrigin
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping("hotels/{hotelId}/rooms")
	public List<RoomDto> getAllRoomsInHotel(@PathVariable("hotelId") int hotelId){
		return roomService.getAllRoomsInHotel(hotelId);
	}
	
	
	
}
