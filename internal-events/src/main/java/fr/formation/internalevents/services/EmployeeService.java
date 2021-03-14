package fr.formation.internalevents.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import fr.formation.internalevents.dtos.EmployeeCreateDto;
import fr.formation.internalevents.dtos.EmployeeInfoDto;

public interface EmployeeService extends UserDetailsService {

	void create(EmployeeCreateDto dto);

	boolean uniqueUsername(String value);

	boolean uniqueEmail(String value);

	EmployeeInfoDto getCurrentEmployeeInfo(Long id);

}
