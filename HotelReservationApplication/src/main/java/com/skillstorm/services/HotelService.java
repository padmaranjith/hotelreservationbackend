package com.skillstorm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.HotelDto;
import com.skillstorm.dtos.RoomDto;
import com.skillstorm.models.Hotel;
import com.skillstorm.models.Location;
import com.skillstorm.repositories.IHotelRepository;
import com.skillstorm.repositories.ILocationRepository;
import com.skillstorm.repositories.IRoomRepository;

@Service
@Transactional
public class HotelService {
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	@Autowired
	private ILocationRepository locationRepository;
	
	public List<HotelDto> getAllHotels(){
		return hotelRepository.findAll()
				.stream()
				.map(hotel->hotel.toDto())
				.toList();
	}
	
	public List<HotelDto> getHotelsByLocation(String locationName){
		
		Location location= locationRepository.getLocationByLocationName(locationName);
		System.out.println("Location "+location);
		if(location !=null) {
			System.out.println("Getting all hotels by location ...");
			return hotelRepository.findAllByLocationId(location.getId())
					.stream()
					.map(hotel->hotel.toDto())
					.toList();	
			}
		else {
			throw new RuntimeException("Sorry, Currently we do not have any hotels in your selected location");
		}
	}
	
}
