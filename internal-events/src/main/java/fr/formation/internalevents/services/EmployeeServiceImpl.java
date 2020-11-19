package fr.formation.internalevents.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.internalevents.config.EmployeeDetails;
import fr.formation.internalevents.config.ResourceNotFoundException;
import fr.formation.internalevents.dtos.EmployeeAuthDto;
import fr.formation.internalevents.dtos.EmployeeCreateDto;
import fr.formation.internalevents.dtos.EmployeeInfoDto;
import fr.formation.internalevents.entities.Employee;
import fr.formation.internalevents.entities.Role;
import fr.formation.internalevents.repositories.EmployeeRepository;
import fr.formation.internalevents.repositories.RoleRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    private final EmployeeRepository employeeRepository;
    
    private final RoleRepository roleRepository;
    
    protected EmployeeServiceImpl(PasswordEncoder passwordEncoder, EmployeeRepository employeeRepository,
			RoleRepository roleRepository) {
		this.passwordEncoder = passwordEncoder;
		this.employeeRepository = employeeRepository;
		this.roleRepository = roleRepository;
	}

    @Override
    public void create(EmployeeCreateDto dto) {
    	
    	Role role = roleRepository.findByDefaultRole(true);
    	Set<Role> roles = new HashSet<>();
    	roles.add(role);
    	Employee employee = new Employee();
    	employee.setUsername(dto.getUsername());
    	employee.setFirstname(dto.getFirstname());
    	employee.setLastname(dto.getLastname());
    	employee.setEmail(dto.getEmail());
    	employee.setPassword(passwordEncoder.encode(dto.getPassword()));
    	employee.setRoles(roles);
    	employeeRepository.save(employee);
    }
    
    // Throws UsernameNotFoundException (Spring contract)
    @Override
    public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	EmployeeAuthDto user = employeeRepository.findByUsername(username)
		.orElseThrow(() -> new UsernameNotFoundException(
			"no employee found with username: " + username));
	return new EmployeeDetails(user);
    }

    // Throws ResourceNotFoundException (restful practice)
    @Override
    public EmployeeInfoDto getCurrentEmployeeInfo(Long id) {
    	return employeeRepository.getById(id).orElseThrow(() -> new ResourceNotFoundException("with id:" + id));
    }
    
}
