package fr.formation.internalevents.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.internalevents.dtos.EventCreateDto;
import fr.formation.internalevents.dtos.EventFullInfoDto;
import fr.formation.internalevents.dtos.EventShortInfoDto;
import fr.formation.internalevents.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	private final EventService service;

	@Autowired
	public EventController(EventService service) {
		this.service = service;
	}

	/**
	 * Endpoint to create a resource (event)
	 * 
	 */
	@PostMapping
	public void createEvent(@Valid @RequestBody EventCreateDto dto) {
		service.create(dto);
	}

	/**
	 * Endpoint to retrieve a short info of all the resources (events)
	 * 
	 * @return a view of all the resources
	 * 
	 */
	@GetMapping
	public List<EventShortInfoDto> getAll() {
		return service.getAll();
	}

	/**
	 * Endpoint to retrieve the details of a single resource (event) with given id
	 * 
	 * @param id, the id of the resource to retrieve
	 * @return a view of the resource
	 * 
	 */
	@GetMapping("{id}")
	public EventFullInfoDto getOneEvent(@PathVariable("id") Long id) {
		return service.getOneEvent(id);
	}
}
