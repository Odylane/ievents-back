package fr.formation.internalevents.dtos;

import java.time.LocalDateTime;

/**
 * 
 * This DTO represents a view of a brief summary of an {@code Event}
 *
 */
public class EventShortInfoDto {

	private Long id;

	private String title;

	private LocalDateTime startDateTime;

	private String nameRoom;

	private String nameEventType;

	private String nameBuilding;

	public EventShortInfoDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getNameRoom() {
		return nameRoom;
	}

	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}

	public String getNameEventType() {
		return nameEventType;
	}

	public void setNameEventType(String nameEventType) {
		this.nameEventType = nameEventType;
	}

	public String getNameBuilding() {
		return nameBuilding;
	}

	public void setNameBuilding(String nameBuilding) {
		this.nameBuilding = nameBuilding;
	}

}
