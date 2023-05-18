package com.skillstorm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.RoomDto;
import com.skillstorm.repositories.IRoomRepository;

@Service
@Transactional
public class RoomService {

	@Autowired
	private IRoomRepository roomRepository;
	
	public List<RoomDto> getAllRoomsInHotel(int hotelId){
		return roomRepository.findAllByHotelHotelId(hotelId)
				.stream()
				.map(room->room.toDto())
				.toList();
				
	}
}