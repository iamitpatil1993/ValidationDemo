package com.example.validation.propertyaccess;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author amit patil This class is used to demo property-access in validation
 *
 */
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5945472023032654744L;

	private String manufacturer;

	private String licencePlat;

	private Integer seatCount;

	public Car(String manufacturer, String licencePlat, Integer seatCount) {
		this.manufacturer = manufacturer;
		this.licencePlat = licencePlat;
		this.seatCount = seatCount;
	}

	public Car() {
	}

	@NotNull(message = "Car manufacturer can not be null")
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@NotNull(message = "licencePlat can not be null")
	@Size(min = 2, max = 4)
	public String getLicencePlat() {
		return licencePlat;
	}

	public void setLicencePlat(String licencePlat) {
		this.licencePlat = licencePlat;
	}

	@NotNull(message = "seatCount can not be null")
	@Min(value = 2, message = "Car must have at least {value} seats")
	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
}
