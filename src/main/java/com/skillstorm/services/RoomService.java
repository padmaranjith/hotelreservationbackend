package com.skillstorm.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.RoomDto;
import com.skillstorm.models.Hotel;
import com.skillstorm.models.Room;
import com.skillstorm.repositories.IHotelRepository;
import com.skillstorm.repositories.IRoomRepository;

@Service
@Transactional
public class RoomService {

	@Autowired
	private IRoomRepository roomRepository;
	@Autowired
	private IHotelRepository hotelRepository;
	
	public List<RoomDto> getAllRoomsInHotel(int hotelId){
		return roomRepository.findAllByHotelHotelId(hotelId)
				.stream()
				.map(room->room.toDto())
				.toList();
	}
	
	public RoomDto getRoomByRoomId(int roomId) {
		return roomRepository.findById(roomId)
				.orElseThrow()
				.toDto();
	}
	
	public void updateRoom(RoomDto roomData) {
		
		//Get hotel by id
		Hotel hotel=hotelRepository.findById(roomData.getHotelId())
				.orElseThrow(()->new RuntimeException("Hotel not found"));
		//Update the room availability
			Room room=new Room();
			room.setRoomId(roomData.getRoomId());
			room.setRoomType(roomData.getRoomType());
			room.setRoomDescription(roomData.getRoomDescription());
		    room.setPrice(roomData.getPrice());
		    room.setAvailability(roomData.isAvailability());
		    room.setImageUrl(roomData.getImageUrl());
		    room.setHotel(hotel);
		    roomRepository.save(room);
		
	}
}
