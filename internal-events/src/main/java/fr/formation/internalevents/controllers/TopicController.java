package fr.formation.internalevents.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.internalevents.dtos.TopicCreateDto;
import fr.formation.internalevents.dtos.TopicDto;
import fr.formation.internalevents.services.TopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {

	private final TopicService service;

	public TopicController(TopicService service) {
		this.service = service;
	}

	/*
	 * Endpoint to retrieve all the topics
	 */
	@GetMapping
	public List<TopicDto> getAll() {
		return service.getAll();
	}

	/*
	 * Endpoint to add a topic in the database, accessible with role "ADMIN"
	 */

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addNewTopic(@Valid @RequestBody TopicCreateDto input) {
		service.create(input);
	}

}
