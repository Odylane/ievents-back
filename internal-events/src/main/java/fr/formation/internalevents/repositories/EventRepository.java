package fr.formation.internalevents.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.dtos.EventFullInfoDto;
import fr.formation.internalevents.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findByStartDateTimeGreaterThanOrderByStartDateTimeAsc(LocalDateTime startDateTime);

	EventFullInfoDto getById(Long id);

}
