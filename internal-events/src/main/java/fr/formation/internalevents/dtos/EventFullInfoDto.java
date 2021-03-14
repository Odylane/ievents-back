package fr.formation.internalevents.dtos;

import java.time.LocalDateTime;

/**
 * An interface representing a view of an {@code Event} detailed
 * 
 */
public interface EventFullInfoDto {

	Long getId();

	String getTitle();

	LocalDateTime getStartDateTime();

	LocalDateTime getEndDateTime();

	String getDescription();

	int getNumberOfAttendees();

	String getSpeakerName();

	String getEventTypeName();

	String getRoomName();

	String getRoomBuildingName();

	String getEmployeeOrganizerFirstname();

	String getEmployeeOrganizerLastname();

}
