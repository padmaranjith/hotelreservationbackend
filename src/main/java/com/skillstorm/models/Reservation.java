package com.skillstorm.models;


import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skillstorm.dtos.ReservationDto;

@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
    private long id;
	
	@Column(name = "check_in_date")
    private ZonedDateTime  checkInDate;
	
	@Column(name = "check_out_date")
    private ZonedDateTime  checkOutDate;
	
	@Column(name = "num_guests")
    private Integer numGuests;
	
	@Column(name = "booking_date")
    private ZonedDateTime  bookingDate;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
	@Column(name = "reservation_status")
    private String reservationStatus;
	
	@ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	public Reservation() {
		
	}
	
	public Reservation(long id, ZonedDateTime checkInDate, ZonedDateTime checkOutDate, Integer numGuests,
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

	public ReservationDto toDto() {
		return new ReservationDto(id, checkInDate, checkOutDate, numGuests, bookingDate, totalPrice, reservationStatus, room.getRoomId(), user.getUserId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", numGuests=" + numGuests + ", bookingDate=" + bookingDate + ", totalPrice=" + totalPrice
				+ ", reservationStatus=" + reservationStatus + ", room=" + room + ", user=" + user + "]";
	}

	
	
}
