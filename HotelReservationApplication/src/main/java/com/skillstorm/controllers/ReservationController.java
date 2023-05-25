package com.skillstorm.controllers;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

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
import com.skillstorm.dtos.RoomDto;
import com.skillstorm.dtos.UserDto;
import com.skillstorm.exceptionHandler.RoomNotAvailableException;
import com.skillstorm.services.EmailService;
import com.skillstorm.services.ReservationService;
import com.skillstorm.services.RoomService;
import com.skillstorm.services.UserService;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {
	@Autowired
	private  ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	private final EmailService emailService;

	@Autowired
	public ReservationController(EmailService emailService) {
	      this.emailService = emailService;
	 }
	
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

//    @PostMapping
//    public ResponseEntity<ReservationDto> createReservation(@Valid @RequestBody ReservationDto reservationData){
//    	ReservationDto reservation = reservationService.createReservation(reservationData);
//    	   	
//    	return new ResponseEntity<>(reservation, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@Valid @RequestBody ReservationDto reservationData){
    	
    	long userId=reservationData.getUserId();
    	int roomId=reservationData.getRoomId();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    	
    	if(Objects.nonNull(userId)&& Objects.nonNull(roomId)) {
    		ReservationDto reservation = reservationService.createReservation(reservationData);
    		//Get user based on user id
    		UserDto user = userService.getUserByUserId(userId);
    		
    		//Get Room based on room id
    		RoomDto room = roomService.getRoomByRoomId(roomId);
    		
    		//Change the availability and update
    		room.setAvailability(false);
    		roomService.updateRoom(room);
    		
    		 //Send email to the user
            String to = user.getEmail();
            
            //Email Subject
            String subject = "Room Reservation Confirmation";
            
            //Confirmation Message to the user
            String body = "Dear " + user.getFirstName() +" "+ user.getLastName()
            + ",\n\nThank you for choosing Grand Vista to book your upcoming stay."
            + "We are pleased to confirm your reservation details."
            +"\n\nYour Booking Summary"
            
            +"\n\nCheck In Date : "+reservation.getCheckInDate().format(formatter)
            +"\nCheck Out Date : "+reservation.getCheckOutDate().format(formatter)
            +"\nNumber of Guests :"+reservation.getNumGuests()
            +"\nRoom Type: "+room.getRoomType()
            +"\nTotal Price : "+reservation.getTotalPrice()
            +"\n\nIf you have any questions or require further assistance,"
            + "please don't hesitate to contact our customer service team at inboxgrandvista@gmail.com"
            +"\n\nThank you for choosing Grand Vista. We hope you have a pleasant stay!"
            +"\n\nBest regards,"
            + "\nGrand Vista.";
            
            emailService.sendEmail(to, subject, body);
        	
            System.out.println("Email sent successfully");
            
        	return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    	}
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
