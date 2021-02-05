package fr.formation.internalevents.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * get all topics
	 */
	@GetMapping
	public List<TopicDto> getAll() {
		return service.getAll();
	}

}
