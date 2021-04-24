package fr.formation.internalevents.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Custom annotation {@code UniqueUsername} to ensure the username is unique
 * 
 * @author Catherine Nobyn
 *
 */

@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {

	String message() default "Saisie invalide";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
