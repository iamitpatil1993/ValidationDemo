package com.example.validation.inheritance;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 
 * @author amit patil
 * This is to demo how validation works in case of inheritance
 *
 */
public class RentalCar extends Car {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3781781615936271968L;

	@NotBlank
	private String rentalStation;

	public RentalCar(final String rentalStation, final String manufaturer) {
		super(manufaturer);
		this.rentalStation = rentalStation;
	}

	public RentalCar() {
		// Nothing to do here
	}

	public String getRentalStation() {
		return rentalStation;
	}

	public void setRentalStation(String rentalStation) {
		this.rentalStation = rentalStation;
	}

	@Size(min = 2, max = 20)
	public String getManufacturer() {
		return super.getManufacturer();
	}
}
