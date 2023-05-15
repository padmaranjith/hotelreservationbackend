package com.skillstorm.dtos;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import com.skillstorm.models.User;

public class ReservationDto {
	
    private Long id;
	
    private ZonedDateTime  checkInDate;
	
    private ZonedDateTime  checkOutDate;
	
    private Integer numGuests;
	
    private ZonedDateTime  bookingDate;
    
    private BigDecimal totalPrice;
	
    private String reservationStatus;
	
    private Room room;
	
    private User user;

    
	public ReservationDto() {
		
	}

	public ReservationDto(Long id, ZonedDateTime checkInDate, ZonedDateTime checkOutDate, Integer numGuests,
			ZonedDateTime bookingDate, BigDecimal totalPrice, String reservationStatus, Room room, User user) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numGuests = numGuests;
		this.bookingDate = bookingDate;
		this.totalPrice = totalPrice;
		this.reservationStatus = reservationStatus;
		this.room = room;
		this.user = user;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(ZonedDateTime checkInDate) {
		this.checkInDate = checkInDate;
	}

	public ZonedDateTime getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(ZonedDateTime checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Integer getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(Integer numGuests) {
		this.numGuests = numGuests;
	}

	public ZonedDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(ZonedDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, checkInDate, checkOutDate, id, numGuests, reservationStatus, totalPrice, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationDto other = (ReservationDto) obj;
		return Objects.equals(bookingDate, other.bookingDate) && Objects.equals(checkInDate, other.checkInDate)
				&& Objects.equals(checkOutDate, other.checkOutDate) && Objects.equals(id, other.id)
				&& Objects.equals(numGuests, other.numGuests)
				&& Objects.equals(reservationStatus, other.reservationStatus)
				&& Objects.equals(totalPrice, other.totalPrice) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "ReservationDto [id=" + id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", numGuests=" + numGuests + ", bookingDate=" + bookingDate + ", totalPrice=" + totalPrice
				+ ", reservationStatus=" + reservationStatus + ", user=" + user + "]";
	}

	
    
    

}
