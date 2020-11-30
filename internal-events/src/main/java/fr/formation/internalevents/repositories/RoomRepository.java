package fr.formation.internalevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
