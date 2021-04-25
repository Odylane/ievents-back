package fr.formation.internalevents.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.internalevents.config.SecurityHelper;
import fr.formation.internalevents.dtos.EventCreateDto;
import fr.formation.internalevents.dtos.EventFullInfoDto;
import fr.formation.internalevents.dtos.EventShortInfoDto;
import fr.formation.internalevents.entities.Employee;
import fr.formation.internalevents.entities.Event;
import fr.formation.internalevents.entities.EventType;
import fr.formation.internalevents.entities.Room;
import fr.formation.internalevents.entities.Topic;
import fr.formation.internalevents.exceptions.ResourceNotFoundException;
import fr.formation.internalevents.repositories.EmployeeRepository;
import fr.formation.internalevents.repositories.EventRepository;
import fr.formation.internalevents.repositories.EventTypeRepository;
import fr.formation.internalevents.repositories.RoomRepository;
import fr.formation.internalevents.repositories.TopicRepository;

@Service
public class EventServiceImpl implements EventService {

	private final EventRepository eventRepo;

	private final EmployeeRepository employeeRepo;

	private final TopicRepository topicRepo;

	private final EventTypeRepository eventTypeRepo;

	private final RoomRepository roomRepo;

	public EventServiceImpl(EventRepository eventRepo, EmployeeRepository employeeRepo, TopicRepository topicRepo,
			EventTypeRepository eventTypeRepo, RoomRepository roomRepo) {
		this.eventRepo = eventRepo;
		this.employeeRepo = employeeRepo;
		this.topicRepo = topicRepo;
		this.eventTypeRepo = eventTypeRepo;
		this.roomRepo = roomRepo;
	}

	@Transactional
	@Override
	public void create(EventCreateDto dto) {

		Event event = new Event();

		event.setTitle(dto.getTitle());
		event.setDescription(dto.getDescription());
		event.setSpeakerName(dto.getSpeakerName());
		event.setStartDateTime(dto.getStartDateTime());
		event.setEndDateTime(dto.getEndDateTime());
		event.setNumberOfAttendees(dto.getNumberOfAttendees());

		setEventType(event, dto.getEventTypeId());
		setRoom(event, dto.getRoomId());
		setTopic(event, dto.getTopicId());

		Long userId = SecurityHelper.getUserId();
		Employee employeeOrganizer = employeeRepo.getOne(userId);
		event.setEmployeeOrganizer(employeeOrganizer);

		eventRepo.save(event);
	}

	private void setEventType(Event event, Long eventTypeId) {
		EventType eventType = eventTypeRepo.getOne(eventTypeId);
		event.setEventType(eventType);
	}

	private void setRoom(Event event, Long roomId) {
		Room room = roomRepo.getOne(roomId);
		event.setRoom(room);
	}

	private void setTopic(Event event, Long topicId) {
		Topic topic = topicRepo.getOne(topicId);
		event.setTopic(topic);
	}

	@Override
	public List<EventShortInfoDto> getAll() {

		List<Event> events = eventRepo.findByStartDateTimeGreaterThanOrderByStartDateTimeAsc(LocalDateTime.now());
		List<EventShortInfoDto> dtos = new ArrayList<>();

		for (Event event : events) {
			EventShortInfoDto dto = convertFrom(event);
			dtos.add(dto);
		}
		return dtos;

	}

	private EventShortInfoDto convertFrom(Event event) {

		EventShortInfoDto dto = new EventShortInfoDto();
		dto.setId(event.getId());
		dto.setTitle(event.getTitle());
		dto.setStartDateTime(event.getStartDateTime());

		EventType eventType = event.getEventType();
		dto.setNameEventType(eventType.getName());

		Room room = event.getRoom();
		dto.setNameRoom(room.getName());
		Room roomBuilding = event.getRoom();
		dto.setNameBuilding(roomBuilding.getBuilding().getName());

		return dto;

	}

	@Override
	public EventFullInfoDto getOneEvent(Long id) {

		return eventRepo.getById(id).orElseThrow(() -> new ResourceNotFoundException("no event with id: " + id));

	}

	@Override
	public boolean checkRoomCapacity(int numberOfAttendeesByEvent, Long RoomIdRequested) {
		Room roomRequested = roomRepo.findById(RoomIdRequested).orElseThrow(() -> new NullPointerException());
		int roomCapacity = roomRequested.getCapacity();
		return (numberOfAttendeesByEvent <= roomCapacity);
	}

}
