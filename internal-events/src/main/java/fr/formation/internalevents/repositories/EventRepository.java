package fr.formation.internalevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.entities.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long>  {

	
}
