package com.example.validation.objectgraph;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3502080577911892844L;

	@NotBlank
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public Person() {
		// Nothing to do here
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
