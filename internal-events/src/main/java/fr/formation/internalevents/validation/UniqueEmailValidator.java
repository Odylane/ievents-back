package fr.formation.internalevents.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.internalevents.services.EmployeeService;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	private EmployeeService service;

	public UniqueEmailValidator(EmployeeService service) {
		this.service = service;
	}

	/**
	 * Method to check if the email is valid
	 */

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return service.uniqueEmail(value);
	}

}
