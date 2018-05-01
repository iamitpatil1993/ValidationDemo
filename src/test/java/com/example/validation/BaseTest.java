package com.example.validation;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;

public class BaseTest {

	// Validator is supposed to be thread safe as per specifications, so we can
	// reuse same validator for all test cases.
	protected static Validator validator = null;

	@BeforeClass
	public static void beforeClass() {

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
}
