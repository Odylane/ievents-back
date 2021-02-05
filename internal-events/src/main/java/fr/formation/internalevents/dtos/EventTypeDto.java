package fr.formation.internalevents.dtos;

public class EventTypeDto {

	private final Long id;

	private final String name;

	public EventTypeDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
