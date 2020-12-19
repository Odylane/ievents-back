package fr.formation.internalevents.dtos;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.formation.internalevents.validation.NotAdequateRoomCapacity;

@NotAdequateRoomCapacity
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
	private EventTypeDto eventType;

	@Valid
	private TopicDto topic;

	@Valid
	private RoomDto room;

	@Valid
	private EmployeeDto employeeOrganizer;

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

	public EventTypeDto getEventType() {
		return eventType;
	}

	public void setEventType(EventTypeDto eventType) {
		this.eventType = eventType;
	}

	public TopicDto getTopic() {
		return topic;
	}

	public void setTopic(TopicDto topic) {
		this.topic = topic;
	}

	public RoomDto getRoom() {
		return room;
	}

	public void setRoom(RoomDto room) {
		this.room = room;
	}

	public EmployeeDto getEmployeeOrganizer() {
		return employeeOrganizer;
	}

	public void setEmployeeOrganizer(EmployeeDto employeeOrganizer) {
		this.employeeOrganizer = employeeOrganizer;
	}

}
