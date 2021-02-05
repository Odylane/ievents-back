package fr.formation.internalevents.dtos;

public class RoomDto {

	private Long id;

	private String name;

	private String nameBuilding;

	public RoomDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public RoomDto(Long id, String name, String nameBuilding) {
		this.id = id;
		this.name = name;
		this.nameBuilding = nameBuilding;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNameBuilding() {
		return nameBuilding;
	}

}
