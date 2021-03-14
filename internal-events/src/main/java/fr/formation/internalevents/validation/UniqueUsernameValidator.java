package fr.formation.internalevents.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.internalevents.services.EmployeeService;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	private EmployeeService service;

	public UniqueUsernameValidator(EmployeeService service) {
		this.service = service;
	}

	/**
	 * Method to check if username is valid
	 */

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return service.uniqueUsername(value);
	}

}
