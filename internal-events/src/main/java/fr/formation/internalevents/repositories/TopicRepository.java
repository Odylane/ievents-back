package fr.formation.internalevents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.dtos.TopicDto;
import fr.formation.internalevents.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	@Query("select new fr.formation.internalevents.dtos.TopicDto"
			+ "(top.id, top.name) from Topic top order by top.name asc")
	List<TopicDto> getAllProjected();

}
