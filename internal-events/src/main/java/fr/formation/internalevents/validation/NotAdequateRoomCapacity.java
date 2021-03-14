package fr.formation.internalevents.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = NotAdequateRoomCapacityValidator.class)
public @interface NotAdequateRoomCapacity {

	String message() default "La capacité de la salle est insuffisante par rapport au nombre de participants prévu pour votre événement.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
