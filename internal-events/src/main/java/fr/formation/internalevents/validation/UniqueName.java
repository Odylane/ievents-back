package fr.formation.internalevents.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Custom annotation {@code UniqueName} to ensure the topic is unique
 * 
 * @author Catherine Nobyn
 *
 */

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = UniqueNameValidator.class)
public @interface UniqueName {

	String message() default "Cette thématique existe déjà";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
