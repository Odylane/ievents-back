package fr.formation.internalevents.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "events", uniqueConstraints = {
		@UniqueConstraint(name = "UK_start_date_time_speaker_name", columnNames = { "start_date_time",
				"speaker_name" }) }, indexes = {
						@Index(name = "fk_events_event_types_idx", columnList = "event_type_id"),
						@Index(name = "fk_events_topics_idx", columnList = "topic_id"),
						@Index(name = "fk_events_rooms_idx", columnList = "room_id"),
						@Index(name = "fk_events_employees_idx", columnList = "employee_organizer_id") })
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_event")
	private Long id;

	@Column(nullable = false, length = 75)
	private String title;

	@Column(name = "start_date_time", nullable = false)
	private LocalDateTime startDateTime;

	@Column(name = "end_date_time", nullable = false)
	private LocalDateTime endDateTime;

	@Column(nullable = false, length = 2000)
	private String description;

	@Column(name = "nb_of_places", nullable = false)
	private int numberOfPlaces;

	@Column(name = "speaker_name", nullable = false, length = 255)
	private String speakerName;

	@ManyToOne
	@JoinColumn(name = "event_type_id", referencedColumnName = "id_event_type", foreignKey = @ForeignKey(name = "fk_events_event_types"))
	private EventType eventType;

	@ManyToOne
	@JoinColumn(name = "topic_id", referencedColumnName = "id_topic", foreignKey = @ForeignKey(name = "fk_events_topics"))
	private Topic topic;

	@ManyToOne
	@JoinColumn(name = "room_id", referencedColumnName = "id_room", foreignKey = @ForeignKey(name = "fk_events_rooms"))
	private Room room;

	@ManyToOne
	@JoinColumn(name = "employee_organizer_id", referencedColumnName = "id_employee", foreignKey = @ForeignKey(name = "fk_events_employees"))
	private Employee employeeOrganizer;

	public Event() {
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

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Employee getEmployeeOrganizer() {
		return employeeOrganizer;
	}

	public void setEmployeeOrganizer(Employee employeeOrganizer) {
		this.employeeOrganizer = employeeOrganizer;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + ", description=" + description + ", numberOfPlaces=" + numberOfPlaces + ", speakerName="
				+ speakerName + ", eventType=" + eventType + ", topic=" + topic + ", room=" + room
				+ ", employeeOrganizer=" + employeeOrganizer + "]";
	}

}
