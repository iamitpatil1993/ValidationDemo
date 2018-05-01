package com.example.validation.propertyaccess;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.example.validation.BaseTest;

/**
 * 
 * @author amit patil This class is used to demo property-access in validation
 *
 */
public class CarTest extends BaseTest {

	@Test
	public void validationPropertyAccessFailTest() {
		// given
		Car car = new Car();

		// when
		Set<ConstraintViolation<Car>> errors = validator.validate(car);

		// then
		assertNotNull(errors);
		assertThat(errors.size(), greaterThan(0));

		logError(errors);
	}

	@Test
	public void validationPropertyAccessFail1Test() {
		// given
		Car car = new Car("Toyota", "1", 1);

		// when
		Set<ConstraintViolation<Car>> errors = validator.validate(car);

		// then
		assertNotNull(errors);
		assertThat(errors.size(), greaterThan(0));

		logError(errors);
	}

	@Test
	public void validationPropertyAccessSuccessTest() {
		// given
		Car car = new Car("Toyota", "936", 3);

		// when
		Set<ConstraintViolation<Car>> errors = validator.validate(car);

		// then
		assertNotNull(errors);
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
		});
	}
}
