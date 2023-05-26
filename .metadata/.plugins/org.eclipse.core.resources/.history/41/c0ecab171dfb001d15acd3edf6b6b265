package com.skillstorm.dtos;

import java.math.BigDecimal;
import java.util.Objects;

public class RoomDto {
	
	private int roomId;

	private String roomType;

	private String roomDescription;

	private BigDecimal price;

	private boolean availability;
	
	private int reservationId;
	private int hotelId;
	
	private String imageUrl;
	
	public RoomDto() {
		
	}
	
	public RoomDto(int roomId, String roomType, String roomDescription, BigDecimal price, boolean availability,
			int reservationId, int hotelId, String imageUrl) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomDescription = roomDescription;
		this.price = price;
		this.availability = availability;
		this.reservationId = reservationId;
		this.hotelId = hotelId;
		this.imageUrl = imageUrl;
	}

	public int getRoomId() {
		return roomId;
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

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	@Override
	public String toString() {
		return "RoomDto [roomId=" + roomId + ", roomType=" + roomType + ", roomDescription=" + roomDescription
				+ ", price=" + price + ", availability=" + availability + ", reservationId=" + reservationId
				+ ", hotelId=" + hotelId + ", imageUrl=" + imageUrl + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(availability, price, reservationId, roomDescription, roomId, roomType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomDto other = (RoomDto) obj;
		return availability == other.availability && Objects.equals(price, other.price)
				&& reservationId == other.reservationId && Objects.equals(roomDescription, other.roomDescription)
				&& roomId == other.roomId && Objects.equals(roomType, other.roomType);
	}

	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	

}
