package fr.formation.internalevents.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.internalevents.services.TopicService;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

	private TopicService service;

	public UniqueNameValidator(TopicService service) {
		this.service = service;
	}

	/**
	 * Method to check if the name is valid
	 */

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return service.uniqueName(value);
	}

}
