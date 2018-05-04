package com.example.validation.objectgraph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author amit patil This is used to test cascaded validation. This feature can
 *         be used with references to other objects and to containers.
 */

public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5997109533650807187L;

	@NotNull
	@Valid
	private Person driver;
	
	List<@Valid Person> passanges = new ArrayList<>(4);
	
	public Car(Person driver) {
		this.driver = driver;
	}

	public Car() {
		// Nothing to do here
	}

	public List<Person> getPassanges() {
		return passanges;
	}

	public void setPassanges(List<Person> passanges) {
		this.passanges = passanges;
	}

	public Person getDriver() {
		return driver;
	}

	public void setDriver(Person driver) {
		this.driver = driver;
	}
	
	public void addPassanges(Person person) {
		this.passanges.add(person);
	}
}
