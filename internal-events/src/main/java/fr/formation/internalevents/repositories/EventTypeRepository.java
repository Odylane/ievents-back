package fr.formation.internalevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.entities.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {


}
