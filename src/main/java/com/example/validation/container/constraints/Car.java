package com.example.validation.container.constraints;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 
 * @author amit patil 
 * @ This class is used to demo, container classes validation(Iterables)
 *
 */
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 839204927091992151L;

	@NotEmpty(message = "Car manufacturer should provide at least one accessory")
	private Set<@NotEmpty @Size(min = 3) String> accessories = new HashSet<>(4);
	
	private List<@Future Calendar> serviceingDates = new ArrayList<>(5); 
	
	private Map<@NotEmpty String, @Min(0) Integer> specifications = new HashMap<>();
	
	private Optional<@NotEmpty String> absType = Optional.empty();
	
	public Optional<String> getAbsType() {
		return absType;
	}

	public void setAbsType(Optional<String> absType) {
		this.absType = absType;
	}

	public Map<String, Integer> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(Map<String, Integer> specifications) {
		this.specifications = specifications;
	}

	public Set<String> getAccessories() {
		return accessories;
	}

	public void setAccessories(Set<String> accessories) {
		this.accessories = accessories;
	}
	
	public void addAccessory(String accessory) {
		accessories.add(accessory);
	}
	
	public void addDate(Calendar date) {
		serviceingDates.add(date);
	}
	
	public void addSpecification(final String specification, final Integer value) {
		specifications.put(specification, value);
	}
}
