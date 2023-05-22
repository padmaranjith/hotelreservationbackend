package com.skillstorm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skillstorm.dtos.ReservationDto;
import com.skillstorm.exceptionHandler.RoomNotAvailableException;
import com.skillstorm.services.ReservationService;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {
	@Autowired
	private  ReservationService reservationService;
	
	@GetMapping
    public List<ReservationDto> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ReservationDto getReservationById(@PathVariable long id) {
        return reservationService.getReservationById(id);
    }
	
    
    @GetMapping("/users/{userId}")
    public List<ReservationDto> getReservationsByUserId(@PathVariable long userId) {
    return reservationService.getReservationsByUserId(userId);
}

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@Valid @RequestBody ReservationDto reservationData){
    	ReservationDto reservation = reservationService.createReservation(reservationData);
    	return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ReservationDto updateReservation(@PathVariable long id, @RequestBody ReservationDto reservationData) {
        reservationData.setId(id);
    	return reservationService.updateReservation(id,reservationData);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable long id) {
        reservationService.deleteReservation(id);
    }
}