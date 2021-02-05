package fr.formation.internalevents.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.internalevents.dtos.EventTypeDto;
import fr.formation.internalevents.repositories.EventTypeRepository;

@Service
public class EventTypeServiceImpl implements EventTypeService {

	private final EventTypeRepository eventTypeRepo;

	public EventTypeServiceImpl(EventTypeRepository eventTypeRepo) {
		this.eventTypeRepo = eventTypeRepo;
	}

	@Override
	public List<EventTypeDto> getAll() {
		return eventTypeRepo.getAllProjected();
	}

}
