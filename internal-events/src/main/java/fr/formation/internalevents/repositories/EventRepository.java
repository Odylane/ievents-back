package fr.formation.internalevents.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.dtos.EventFullInfoDto;
import fr.formation.internalevents.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	/**
	 * A projection of all the events
	 * 
	 * @param startDateTime, the start date time of the event to find
	 * @return a view of all the events ordered by start date time ascending sort
	 */
	List<Event> findByStartDateTimeGreaterThanOrderByStartDateTimeAsc(LocalDateTime startDateTime);

	/**
	 * A projection of one {@code Event} in a {@code EventFullInfoDto}.
	 * 
	 * @param id, the id of the event to retrieve
	 * @return a view of an event
	 */
	EventFullInfoDto getById(Long id);

}
