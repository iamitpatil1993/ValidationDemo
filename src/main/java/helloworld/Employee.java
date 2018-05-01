package helloworld;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Min(value = 0)
	private Long employeeId;
	
	@NotNull
	@Size(min = 2, max = 100, message = "firstName must be of size between 2-100")
	@NotBlank
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 100, message = "lastname must be of size between 2-100")
	@NotBlank
	private String lastName;
	
	@Past
	private Calendar dob;
	
	@PastOrPresent
	private Calendar dateOfJoining;
	
	@NotNull
	@NotBlank
	@Size(min = 10, max = 10)
	private String mobile;
	
	@Email
	private String email;
	
	private String salary;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public Calendar getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Calendar dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
