package fr.formation.internalevents.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.internalevents.dtos.EventCreateDto;
import fr.formation.internalevents.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	private final EventService service;
	
	@Autowired
	public EventController(EventService service) {
		this.service = service;
	}
	
	@PostMapping
	public void createEvent(@Valid @RequestBody EventCreateDto dto) {
		//dto.setEmployeeOrganizer(getEmployeeId());
		service.create(dto);
	}

}
