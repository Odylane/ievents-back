package fr.formation.internalevents.dtos;

import java.time.LocalDateTime;

public interface EventFullInfoDto {

	Long getId();

	String getTitle();

	LocalDateTime getStartDateTime();

	LocalDateTime getEndDateTime();

	String getDescription();

	int getNumberOfPlaces();

	String getSpeakerName();

	String getEventTypeName();

	String getRoomName();

	String getRoomBuildingName();

	String getEmployeeOrganizerFirstname();

	String getEmployeeOrganizerLastname();

}
