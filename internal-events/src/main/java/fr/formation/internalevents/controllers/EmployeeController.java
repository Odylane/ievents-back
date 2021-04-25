package fr.formation.internalevents.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.internalevents.config.SecurityHelper;
import fr.formation.internalevents.dtos.EmployeeCreateDto;
import fr.formation.internalevents.dtos.EmployeeInfoDto;
import fr.formation.internalevents.services.EmployeeService;

@RestController
@RequestMapping
public class EmployeeController {

	private final EmployeeService service;

	protected EmployeeController(EmployeeService service) {
		this.service = service;
	}

	/**
	 * Endpoint to create a resource (employee)
	 * 
	 * @param inputs
	 * 
	 */

	@PostMapping("/employees")
	@ResponseStatus(value = HttpStatus.CREATED)
	protected void addNewAccount(@Valid @RequestBody EmployeeCreateDto inputs) throws MethodArgumentNotValidException {
		service.create(inputs);
	}

	/**
	 * Standard endpoint returning a view of the current authenticated user.
	 * <p>
	 *
	 * @param authentication injected authentication object
	 * @return a view of the current authenticated user
	 */

	@GetMapping("/userInfo")
	protected EmployeeInfoDto userInfo() {
		Long userId = SecurityHelper.getUserId();
		return service.getCurrentEmployeeInfo(userId);
	}

}
