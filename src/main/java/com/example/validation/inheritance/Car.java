package com.example.validation.inheritance;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author amit patil
 * This is to demo how validation works in case of inheritance
 *
 */
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4986505377657618798L;

	private String manufacturer;

	public Car(final String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Car() {
		// Nothing to do here
	}

	@NotNull
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}
