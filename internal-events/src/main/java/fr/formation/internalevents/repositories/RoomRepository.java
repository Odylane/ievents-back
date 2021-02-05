package fr.formation.internalevents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.dtos.RoomDto;
import fr.formation.internalevents.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	@Query("select new fr.formation.internalevents.dtos.RoomDto"
			+ "(roo.id, roo.name) from Room roo order by roo.name asc")
	List<RoomDto> getAllProjected();

}
