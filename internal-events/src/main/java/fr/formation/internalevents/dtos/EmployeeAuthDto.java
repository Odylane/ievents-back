package fr.formation.internalevents.dtos;

import java.util.Set;

import fr.formation.internalevents.entities.Role;

/**
 * A projection of a {@code Employee} for authentication.
 */
public interface EmployeeAuthDto {
	
	Long getId();

	String getUsername();

	String getPassword();
	
	Set<Role> getRoles();
    
}
