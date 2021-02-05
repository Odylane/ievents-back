package fr.formation.internalevents.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.internalevents.dtos.RoomDto;
import fr.formation.internalevents.services.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	private final RoomService service;

	public RoomController(RoomService service) {
		this.service = service;
	}

	/*
	 * get all rooms
	 */
	@GetMapping
	public List<RoomDto> getAll() {
		return service.getAll();
	}

}
