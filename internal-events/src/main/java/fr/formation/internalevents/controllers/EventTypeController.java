package fr.formation.internalevents.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.internalevents.dtos.EventTypeDto;
import fr.formation.internalevents.services.EventTypeService;

@RestController
@RequestMapping("/eventTypes")
public class EventTypeController {

	private final EventTypeService service;

	public EventTypeController(EventTypeService service) {
		this.service = service;
	}

	/*
	 * Endpoint to retrieve all the event types
	 * 
	 */
	@GetMapping
	public List<EventTypeDto> getAll() {
		return service.getAll();
	}

}
