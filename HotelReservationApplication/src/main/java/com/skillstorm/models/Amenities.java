package com.skillstorm.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * Amenity entity represents all amenities associated with the hotel
 *
 */


@Entity
@Table(name="amenities")
public class Amenities {
	
	/**
	 * Unique Identifier for the amenities.
	 * This field is automatically generated and cannot be modified directly
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="amenities_id")
	private int amenitiesId;
	@Column(name="amenities_type")
	private String amenitiesType;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	public Amenities() {
		
	}
	public Amenities(int amenitiesId, String amenitiesType, Hotel hotel) {
		super();
		this.amenitiesId = amenitiesId;
		this.amenitiesType = amenitiesType;
		this.hotel = hotel;
	}
	public int getAmenitiesId() {
		return amenitiesId;
	}
	public void setAmenitiesId(int amenitiesId) {
		this.amenitiesId = amenitiesId;
	}
	public String getAmenitiesType() {
		return amenitiesType;
	}
	public void setAmenitiesType(String amenitiesType) {
		this.amenitiesType = amenitiesType;
	}
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amenitiesId, amenitiesType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amenities other = (Amenities) obj;
		return amenitiesId == other.amenitiesId && Objects.equals(amenitiesType, other.amenitiesType);
	}


	@Override
	public String toString() {
		return "Amenities [amenitiesId=" + amenitiesId + ", amenitiesType=" + amenitiesType + ", hotel=" + hotel + "]";
	}
	
	
	
}
