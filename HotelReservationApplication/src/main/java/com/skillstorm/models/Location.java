package com.skillstorm.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  Location entity Class represents location associated with the hotels
 */
@Entity
@Table(name="locations")
public class Location {
	
	/**
	 * Unique Identifier for the locations.
	 * This field is automatically generated and cannot be modified directly
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="location_id")
	private int id;
	@Column(name="city")
	private String city;
	@Column(name="state_province")
	private String stateProvince;
	@Column(name="country")
	private String country;
	
	public Location(){
		
	}
	
	/**
	 * Creates a new location object with all the specified fields
	 * 
	 * @param locationId
	 * @param city
	 * @param stateProvince
	 * @param country
	 */
	
	public Location(int locationId, String city, String stateProvince, String country) {
		super();
		this.id = locationId;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
		Location other = (Location) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + id + ", city=" + city + ", stateProvince=" + stateProvince
				+ ", country=" + country + "]";
	}
	
	

}
