package com.skillstorm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.dtos.ReservationDto;
import com.skillstorm.exceptionHandler.ReservationNotFoundException;
import com.skillstorm.exceptionHandler.RoomNotAvailableException;
import com.skillstorm.exceptionHandler.RoomNotFoundException;
import com.skillstorm.exceptionHandler.UserNotFoundException;
import com.skillstorm.models.Reservation;
import com.skillstorm.models.Room;
import com.skillstorm.models.User;
import com.skillstorm.repositories.IReservationRepository;
import com.skillstorm.repositories.IRoomRepository;
import com.skillstorm.repositories.IUserRepository;

@Service
public class ReservationService {
	
	@Autowired
	 private  IReservationRepository reservationRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoomRepository roomRepository;
	
	public List<ReservationDto> getAllReservations() {
		return reservationRepository.findAll()
				.stream()
				.map(reservation->reservation.toDto())
				.toList();
	}
	
	public ReservationDto getReservationById(long id) {
		return reservationRepository.getReservationById(id)
				.orElseThrow()
				.toDto();
	}

	public List<ReservationDto> getReservationsByUserId(long userId) {
		 if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User with id " + userId + " not found");
        }
        
        return reservationRepository.findByUser_UserId(userId)
                .stream()
                .map(Reservation::toDto)
                .collect(Collectors.toList());
	}

	@Transactional
	public ReservationDto createReservation(ReservationDto reservationData) throws RoomNotAvailableException {
		 //checking if the user exists in the system
		User user = userRepository.findById(reservationData.getUserId())
            .orElseThrow(() -> new UserNotFoundException("User with id " + reservationData.getUserId() + " not found"));
		
		// checking if the room exists in the hotel
		Room room = roomRepository.findById(reservationData.getRoomId())
            .orElseThrow(() -> new RoomNotFoundException("Room with id " + reservationData.getRoomId() + " not found"));
		
		// checking if the room is already reserved for the chosen period
		 List<Reservation> conflictingReservations = reservationRepository.findConflictingReservations(
            room, reservationData.getCheckInDate(), reservationData.getCheckOutDate());
		 	if (!conflictingReservations.isEmpty()) {
		 	throw new RoomNotAvailableException("The room is not available for the chosen period.");
    }
		// If everything is fine, we can save the reservation
		 	Reservation reservation = new Reservation();
		 	reservation.setUser(user);
		 	reservation.setRoom(room);
		 	reservation.setCheckInDate(reservationData.getCheckInDate());
		 	reservation.setCheckOutDate(reservationData.getCheckOutDate());
		 	reservation.setBookingDate(reservationData.getBookingDate());
		 	reservation.setNumGuests(reservationData.getNumGuests());
		 	reservation.setTotalPrice(reservationData.getTotalPrice());
		 	reservation.setReservationStatus(reservationData.getReservationStatus());
		 	Reservation savedReservation = reservationRepository.save(reservation);
		 	
		 	return reservationRepository.save(reservation).toDto();
	
	}

	public ReservationDto updateReservation(long id, ReservationDto reservationData){
	    //checking if the reservation exists
	    Reservation reservation = reservationRepository.findById(reservationData.getId())
	        .orElseThrow(() -> new ReservationNotFoundException("Reservation with id " + id + " not found"));
	    
	    //checking if the room exists in the hotel
	    Room room = roomRepository.findById(reservationData.getRoomId())
	        .orElseThrow(() -> new RoomNotFoundException("Room with id " + reservationData.getRoomId() + " not found"));

	    //checking if the room is already reserved for the new period
	    List<Reservation> conflictingReservations = reservationRepository.findConflictingReservations(
	        room, reservationData.getCheckInDate(), reservationData.getCheckOutDate());
	    if (conflictingReservations.stream().anyMatch(r -> r.getId() != reservation.getId())) {
	        throw new RoomNotAvailableException("The room is not available for the chosen period.");
	    }
		 
		//If everything is fine, we can update the reservation
    	reservation.setRoom(room);
    	reservation.setCheckInDate(reservationData.getCheckInDate());
    	reservation.setCheckOutDate(reservationData.getCheckOutDate());
    	Reservation updatedReservation = reservationRepository.save(reservation);
    	
    	
    	return reservationRepository.save(reservation).toDto();
    	
	}
	
	
	public void deleteReservation(long id) {
		reservationRepository.deleteById(id);
		
	}



}
