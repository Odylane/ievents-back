package fr.formation.internalevents.services;

import org.springframework.stereotype.Service;

import fr.formation.internalevents.dtos.EventCreateDto;
import fr.formation.internalevents.entities.Employee;
import fr.formation.internalevents.entities.Event;
import fr.formation.internalevents.entities.EventType;
import fr.formation.internalevents.entities.Room;
import fr.formation.internalevents.entities.Topic;
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

	@Override
	public void create(EventCreateDto dto) {

		Event event = new Event();

		event.setTitle(dto.getTitle());
		event.setDescription(dto.getDescription());
		event.setSpeakerName(dto.getSpeakerName());
		event.setStartDateTime(dto.getStartDateTime());
		event.setEndDateTime(dto.getEndDateTime());
		event.setNumberOfPlaces(dto.getNumberOfPlaces());

		Employee employeeOrganizer = employeeRepo.getOne(dto.getEmployeeOrganizer().getId());
		event.setEmployeeOrganizer(employeeOrganizer);

		EventType eventType = eventTypeRepo.getOne(dto.getEventType().getId());
		event.setEventType(eventType);
		Topic topic = topicRepo.getOne(dto.getTopic().getId());
		event.setTopic(topic);
		Room room = roomRepo.getOne(dto.getRoom().getId());
		event.setRoom(room);

		eventRepo.save(event);
	}

}
