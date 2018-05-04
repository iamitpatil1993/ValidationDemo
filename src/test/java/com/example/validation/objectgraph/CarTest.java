package com.example.validation.objectgraph;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.example.validation.BaseTest;
import static org.hamcrest.Matchers.*;

public class CarTest extends BaseTest {

	@Test
	public void objectGraphConstraintFailInParentObjectTest() {
		// given
		Car car = new Car();

		// when
		Set<ConstraintViolation<Car>> errors = validator.validate(car);

		// then
		assertThat(errors, hasSize(1));
		logError(errors);
	}

	@Test
	public void objectGraphConstraintFailInReferencedObjectTest() {
		// given
		Car car = new Car(new Person());

		// when
		Set<ConstraintViolation<Car>> errors = validator.validate(car);

		// then
		assertThat(errors, hasSize(1));
		logError(errors);
	}

	@Test
	public void objectGraphConstraintSuccessTest() {
		// given
		Car car = new Car(new Person("Kishor"));

		// when
		Set<ConstraintViolation<Car>> errors = validator.validate(car);

		// then
		assertThat(errors, empty());
	}

	@Test
	public void containerElementConstraintFailTest() {
		// given
		Car car = new Car(new Person("Kishor"));
		car.addPassanges(new Person());

		// when
		Set<ConstraintViolation<Car>> errors = validator.validate(car);

		// then
		assertThat(errors, hasSize(1));
		logError(errors);
	}

	@Test
	public void containerElementConstraintSuccessTest() {
		// given
		Car car = new Car(new Person("Kishor"));
		car.addPassanges(new Person("AMit"));

		// when
		Set<ConstraintViolation<Car>> errors = validator.validate(car);

		// then
		assertThat(errors, empty());
	}

	private void logError(Set<ConstraintViolation<Car>> errors) {
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
