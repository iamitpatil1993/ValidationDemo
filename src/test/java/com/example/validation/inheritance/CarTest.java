package com.example.validation.inheritance;

import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.example.validation.BaseTest;
import static org.hamcrest.Matchers.*;

/**
 * 
 * @author amit patil
 * This unit test is to demo how validation works in case of inheritance
 *
 */

public class CarTest extends BaseTest {

	@Test
	public void inheritanceWithoutOverrideConstraintFailTest() {
		// given
		RentalCar rentalCar = new RentalCar();
		
		// when
		Set<ConstraintViolation<RentalCar>> errors = validator.validate(rentalCar);
		
		// then
		assertThat(errors, hasSize(2));
		logError(errors);
	}
	
	@Test
	public void inheritanceWithoutOverrideConstraintSuccessTest() {
		// given
		RentalCar rentalCar = new RentalCar("Nigdi, Pune", "Tata Motors");
		
		// when
		Set<ConstraintViolation<RentalCar>> errors = validator.validate(rentalCar);
		
		// then
		assertThat(errors, empty());
		logError(errors);
	}
	
	@Test
	public void inheritanceWithOverrideConstraintFailFromOverridenImplTest() {
		// given
		RentalCar rentalCar = new RentalCar("Nigdi, Pune", "1");
		
		// when
		Set<ConstraintViolation<RentalCar>> errors = validator.validate(rentalCar);
		
		// then
		assertThat(errors, hasSize(1));
		logError(errors);
	}
	
	@Test
	public void inheritanceWithOverrideConstraintFailFromBaseImplTest() {
		// given
		RentalCar rentalCar = new RentalCar("Nigdi, Pune", null);
		
		// when
		Set<ConstraintViolation<RentalCar>> errors = validator.validate(rentalCar);
		
		// then
		assertThat(errors, hasSize(1));
		logError(errors);
	}
	
	@Test
	public void inheritanceWithOverrideConstraintSuccessTest() {
		// given
		RentalCar rentalCar = new RentalCar("Nigdi, Pune", "Tata Motors");
		
		// when
		Set<ConstraintViolation<RentalCar>> errors = validator.validate(rentalCar);
		
		// then
		logError(errors);
	}
	
	private void logError(Set<ConstraintViolation<RentalCar>> errors) {
		errors.forEach(error -> {
			System.out.println(
					"----------------------- " + error.getPropertyPath() + "---------------------------------");
			System.out.println("constraint description :: " + error.getConstraintDescriptor());
			System.out.println("message template :: " + error.getMessageTemplate());
			System.out.println("message :: " + error.getMessage());
			System.out.println("executable parameters :: " + error.getExecutableParameters());
			System.out.println("executable return value :: " + error.getExecutableReturnValue());
			System.out.println("invalid Value :: " + error.getInvalidValue());
			System.out.println("property path :: " + error.getPropertyPath());
		});
	}
}
