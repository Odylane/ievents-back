package fr.formation.internalevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
