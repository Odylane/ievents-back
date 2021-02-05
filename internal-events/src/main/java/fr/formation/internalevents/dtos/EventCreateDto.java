package fr.formation.internalevents.dtos;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@NotAdequateRoomCapacity
public class EventCreateDto {

	@NotBlank
	@Size(max = 75)
	private String title;

	@NotNull
	@Future
	private LocalDateTime startDateTime;

	@NotNull
	@Future
	private LocalDateTime endDateTime;

	@NotBlank
	@Size(max = 2000)
	private String description;

	@Min(value = 2)
	private int numberOfPlaces;

	@NotEmpty(message = "Merci de renseigner le nom de l'intervenant")
	@Size(max = 255)
	private String speakerName;

	@Valid
	private Long eventTypeId;

	@Valid
	private Long topicId;

	@Valid
	private Long roomId;

	@Valid
	private Long employeeOrganizerId;

	public EventCreateDto() {
		//
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(int numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public String getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}

	public Long getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getEmployeeOrganizerId() {
		return employeeOrganizerId;
	}

	public void setEmployeeOrganizerId(Long employeeOrganizerId) {
		this.employeeOrganizerId = employeeOrganizerId;
	}

}
