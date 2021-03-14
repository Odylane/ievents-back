package fr.formation.internalevents.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.internalevents.dtos.EventCreateDto;
import fr.formation.internalevents.services.EventService;

public class NotAdequateRoomCapacityValidator implements ConstraintValidator<NotAdequateRoomCapacity, EventCreateDto> {

	private final EventService service;

	public NotAdequateRoomCapacityValidator(EventService service) {
		this.service = service;
	}

	@Override
	public boolean isValid(EventCreateDto dto, ConstraintValidatorContext context) {
		int numberOfAttendeesByEvent = dto.getNumberOfAttendees();
		Long RoomIdRequested = dto.getRoomId();

		return service.checkRoomCapacity(numberOfAttendeesByEvent, RoomIdRequested);
	}

}
