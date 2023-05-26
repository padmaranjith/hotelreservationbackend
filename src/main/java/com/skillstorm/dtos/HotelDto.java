package com.skillstorm.dtos;

import java.math.BigDecimal;

import java.util.Objects;

public class HotelDto {
	
	private int hotelId;
	private String hotelName;
	private String streetName;
	private String postalCode;
    private String phoneNumber;
	private String email;
	private String description;
	private BigDecimal rating;
	private String imageUrl;
	
	private int locationId;
	
	public HotelDto() {
		
	}

	public HotelDto(int hotelId, String hotelName, String streetName, String postalCode, String phoneNumber,
			String email, String description, BigDecimal rating, String imageUrl, int locationId) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.description = description;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.locationId = locationId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
		
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hotelId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelDto other = (HotelDto) obj;
		return hotelId == other.hotelId;
	}
	
}
