package fr.formation.internalevents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.dtos.EventTypeDto;
import fr.formation.internalevents.entities.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {

	@Query("select new fr.formation.internalevents.dtos.EventTypeDto"
			+ "(evt.id, evt.name) from EventType evt order by evt.name asc")
	List<EventTypeDto> getAllProjected();

}
