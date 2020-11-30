package fr.formation.internalevents.services;

import java.util.List;

import fr.formation.internalevents.dtos.EventCreateDto;
import fr.formation.internalevents.dtos.EventShortInfoDto;

public interface EventService {

	void create(EventCreateDto dto);

	List<EventShortInfoDto> getAll();

}
