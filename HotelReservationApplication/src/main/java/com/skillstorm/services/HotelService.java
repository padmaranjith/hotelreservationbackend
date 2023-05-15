package com.skillstorm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.HotelDto;
import com.skillstorm.repositories.IHotelRepository;

@Service
@Transactional
public class HotelService {
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	public List<HotelDto> getAllHotels(){
		return hotelRepository.findAll()
				.stream()
				.map(hotel->hotel.toDto())
				.toList();
	}

}
