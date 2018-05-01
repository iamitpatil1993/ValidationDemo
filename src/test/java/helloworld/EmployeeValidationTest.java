package helloworld;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.example.validation.BaseTest;


public class EmployeeValidationTest extends BaseTest {

	@Test
	public void test() {
		Employee employee = new Employee();
		Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
		assertNotNull(constraintViolations);
		assertThat(constraintViolations.size(), greaterThan(0));
		
		constraintViolations.forEach(constraintViolation -> {
			System.out.println("----------------------- " + constraintViolation.getPropertyPath() + "---------------------------------");
			System.out.println("constraint description :: " + constraintViolation.getConstraintDescriptor());
			System.out.println("message template :: " + constraintViolation.getMessageTemplate());
			System.out.println("message :: " + constraintViolation.getMessage());
			System.out.println("executable parameters :: " + constraintViolation.getExecutableParameters());
			System.out.println("executable return value :: " + constraintViolation.getExecutableReturnValue());
			System.out.println("invalid Value :: " + constraintViolation.getInvalidValue());
		});
	}
}
