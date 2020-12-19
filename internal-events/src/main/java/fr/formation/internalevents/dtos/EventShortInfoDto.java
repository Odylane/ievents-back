package fr.formation.internalevents.dtos;

import java.time.LocalDateTime;

public class EventShortInfoDto {

	private Long idEvent;

	private String title;

	private LocalDateTime startDateTime;

	private LocalDateTime endDateTime;

	private String nameRoom;

	private String nameEventType;

	private String nameBuilding;

	public EventShortInfoDto() {
	}

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
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

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
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
