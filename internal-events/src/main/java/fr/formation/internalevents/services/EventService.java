package fr.formation.internalevents.services;

import fr.formation.internalevents.dtos.EventCreateDto;

public interface EventService {
	
	void create(EventCreateDto dto);
	
}
