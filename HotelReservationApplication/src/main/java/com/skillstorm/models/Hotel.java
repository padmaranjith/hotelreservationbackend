package com.skillstorm.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.skillstorm.dtos.HotelDto;

/**
 * 
 * Hotel entity Class represents a hotel in the hotel reservation application
 * This entity also contains other fields like hotelName,street,postal code ,
 * phone number,email id,description of the hotel,rating information.
 */

@Entity
@Table(name="hotels")
public class Hotel {
	/**
	 * Unique Identifier for the hotel.
	 * This field is automatically generated and cannot be modified directly
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private int hotelId;
	@Column(name = "hotel_name")
	private String hotelName;
	@Column(name = "street")
	private String streetName;
	@Column(name ="postal_zip_code")
	private String postalCode;
	@Column(name="phone_number")
    private String phoneNumber;
	@Column(name="email")
	private String email;
	@Column(name="description")
	private String description;
	@Column(name="rating",precision = 3,scale = 2)
	private BigDecimal rating;
	@Column (name="imageurl")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;

	
	public Hotel(){
		
	}
	/**
	 * Creates a new hotel object with all the specified fields
	 * 
	 * @param hotelId
	 * @param hotelName
	 * @param streetName
	 * @param postalCode
	 * @param phoneNumber
	 * @param email
	 * @param description
	 * @param rating
	 * @param imageUrl
	 * @param location
	 * 
	 */
	
	public int getHotelId() {
		return hotelId;
	}
	public Hotel(int hotelId, String hotelName, String streetName, String postalCode, String phoneNumber, String email,
			String description, BigDecimal rating, String imageUrl, Location location) {
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
		this.location = location;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public HotelDto toDto() {
		return new HotelDto(hotelId, hotelName, streetName, postalCode, phoneNumber, email, description, rating, imageUrl, location.getId());
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
		Hotel other = (Hotel) obj;
		return hotelId == other.hotelId;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", streetName=" + streetName + ", postalCode="
				+ postalCode + ", phoneNumber=" + phoneNumber + ", email=" + email + ", description=" + description
				+ ", rating=" + rating + ", imageUrl=" + imageUrl + ", location=" + location + "]";
	}

	
	
	
	



	
}
