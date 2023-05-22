package com.skillstorm.dtos;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import com.skillstorm.models.Room;
import com.skillstorm.models.User;


public class ReservationDto {
	
    private long id;
	
    private ZonedDateTime  checkInDate;
	
    private ZonedDateTime  checkOutDate;
	
    private Integer numGuests;
	
    private ZonedDateTime  bookingDate;
    
    private BigDecimal totalPrice;
	
    private String reservationStatus;
	
    private int roomId;
	
    private long userId;

    
	public ReservationDto() {
		
	}


	public ReservationDto(long id, ZonedDateTime checkInDate, ZonedDateTime checkOutDate, Integer numGuests,
			ZonedDateTime bookingDate, BigDecimal totalPrice, String reservationStatus, int roomId, long userId) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numGuests = numGuests;
		this.bookingDate = bookingDate;
		this.totalPrice = totalPrice;
		this.reservationStatus = reservationStatus;
		this.roomId = roomId;
		this.userId = userId;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, checkInDate, checkOutDate, id, numGuests, reservationStatus, roomId,
				totalPrice, userId);
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
				&& Objects.equals(checkOutDate, other.checkOutDate) && id == other.id
				&& Objects.equals(numGuests, other.numGuests)
				&& Objects.equals(reservationStatus, other.reservationStatus) && roomId == other.roomId
				&& Objects.equals(totalPrice, other.totalPrice) && userId == other.userId;
	}


	@Override
	public String toString() {
		return "ReservationDto [id=" + id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", numGuests=" + numGuests + ", bookingDate=" + bookingDate + ", totalPrice=" + totalPrice
				+ ", reservationStatus=" + reservationStatus + ", roomId=" + roomId + ", userId=" + userId + "]";
	}




	
	

	
	
    
    

}
