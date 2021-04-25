package fr.formation.internalevents.dtos;

/**
 * A projection of a {@code Employee} for employee info.
 */
public interface EmployeeInfoDto {

	Long getId();

	String getUsername();

	String getFirstname();

	String getLastname();

	String getEmail();

}
