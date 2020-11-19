package fr.formation.internalevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.internalevents.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByDefaultRole(boolean defaultRole);

}
