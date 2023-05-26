package com.skillstorm.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.HotelDto;
import com.skillstorm.models.Amenities;
import com.skillstorm.models.Hotel;
import com.skillstorm.models.Location;
import com.skillstorm.repositories.IAmenitiesRepository;
import com.skillstorm.repositories.IHotelRepository;
import com.skillstorm.repositories.ILocationRepository;

@Service
@Transactional
public class HotelService {
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	@Autowired
	private ILocationRepository locationRepository;
	
	@Autowired
	private IAmenitiesRepository amenitiesRepository;
	
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
			return hotelRepository.findAll()
					.stream()
					.map(hotel->hotel.toDto())
					.toList();		}
	}
	
	public List<Amenities> getAllAmenitiesInHotel(int hotelId){
		return amenitiesRepository.findAllByHotelHotelId(hotelId);
	}
	
	public Optional<Hotel> getHotelById(int hotelId) {
		return hotelRepository.findById(hotelId);
	}
	
}
