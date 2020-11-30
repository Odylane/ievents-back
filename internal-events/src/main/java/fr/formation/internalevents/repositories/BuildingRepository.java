package fr.formation.internalevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.internalevents.entities.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

}
