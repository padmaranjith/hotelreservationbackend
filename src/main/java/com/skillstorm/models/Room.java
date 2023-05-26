package com.skillstorm.models;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skillstorm.dtos.RoomDto;

/**
 * 
 * Room entity represents all rooms associated with the hotel
 *
 */

@Entity
@Table(name="rooms")
public class Room {

	/**
	 * Unique Identifier for the Room.
	 * This field is automatically generated and cannot be modified directly
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private int roomId;
	@Column(name="room_type")
	private String roomType;
	@Column(name="room_Description")
	private String roomDescription;
	@Column(name="price_per_night")
	private BigDecimal price;
	@Column(name="availability")
	private boolean availability;
	@Column(name="imageurl")
	private String imageUrl;
	
	/*
	 * The hotel that this room belongs to
	 */
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	public Room() {
		
	}

	/**
	 * Creates a new room object with all the specified fields
	 * @param roomId
	 * @param roomType
	 * @param roomDescription
	 * @param price
	 * @param availability
	 * @param hotel
	 */
	

	public int getRoomId() {
		return roomId;
	}

	public Room(int roomId, String roomType, String roomDescription, BigDecimal price, boolean availability,
			String imageUrl, Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomDescription = roomDescription;
		this.price = price;
		this.availability = availability;
		this.imageUrl = imageUrl;
		this.hotel = hotel;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return roomId == other.roomId;
	}

	

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomDescription=" + roomDescription + ", price="
				+ price + ", availability=" + availability + ", imageUrl=" + imageUrl + ", hotel=" + hotel + "]";
	}

	public RoomDto toDto() {
		return new RoomDto(roomId, roomType, roomDescription, price, availability, roomId, hotel.getHotelId(),imageUrl);
	}
	

}
