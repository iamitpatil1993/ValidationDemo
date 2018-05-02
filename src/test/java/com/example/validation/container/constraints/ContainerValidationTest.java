package com.example.validation.container.constraints;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.example.validation.BaseTest;
import static org.hamcrest.Matchers.*;

public class ContainerValidationTest extends BaseTest {

	@Test
	public void accessoriesContainerEmptyValidationTest() {
		// given
		Car car = new Car();

		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		// then
		assertThat(errors.size(), equalTo(1));
		assertEquals("accessories", errors.iterator().next().getPropertyPath().toString());
		logError(errors);
	}

	@Test
	public void iterableContainerElementValidationFailTest() {
		// given
		Car car = new Car();
		car.addAccessory("a");

		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		assertThat(errors.size(), greaterThan(0));
		logError(errors);
	}

	@Test
	public void iterableContainerElementValidationSuccessTest() {
		// given
		Car car = new Car();
		car.addAccessory("adasd");

		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		// then
		logError(errors);
	}

	// In case of list property path will give you index of invalid value. Look for propertyPath in logs
	@Test
	public void listContainerElementValidationFailTest() {
		// given
		Car car = new Car();
		car.addAccessory("adasd");
		car.addDate(Calendar.getInstance());

		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		// then
		assertEquals(1, errors.size());
		logError(errors);
	}

	@Test
	public void listContainerElementValidationSuccessTest() {
		// given
		Car car = new Car();
		car.addAccessory("adasd");
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, 1);
		car.addDate(date);

		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		// then
		assertThat(errors, empty());
	}
	
	@Test
	public void mapContainerElementValidationFailTest() {
		// given
		Car car = new Car();
		car.addAccessory("adasd");
		car.addSpecification("", -1);

		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		// then
		assertThat(errors.size(), equalTo(2));
		logError(errors);
	}
	
	@Test
	public void mapContainerElementValidationSuccessTest() {
		// given
		Car car = new Car();
		car.addAccessory("adasd");
		car.addSpecification("Top Speed", 128);

		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		// then
		assertThat(errors, empty());
		logError(errors);
	}
	
	@Test
	public void optionalContainerElementValidationFailTest() {
		// given
		Car car = new Car();
		car.addAccessory("adasd");
		car.setAbsType(Optional.of(""));
		
		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		// then
		assertThat(errors.size(), equalTo(1));
		logError(errors);
	}
	
	@Test
	public void optionalContainerElementValidationSuccessTest() {
		// given
		Car car = new Car();
		car.addAccessory("adasd");
		car.setAbsType(Optional.of("Dual Channel"));

		// when
		Set<ConstraintViolation<Car>> errors= validator.validate(car);

		// then
		assertThat(errors, empty());
		logError(errors);
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
			System.out.println("property path :: " + error.getPropertyPath().toString());
		});
	}
}
