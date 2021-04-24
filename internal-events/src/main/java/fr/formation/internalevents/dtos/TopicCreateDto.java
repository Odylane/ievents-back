package fr.formation.internalevents.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import fr.formation.internalevents.validation.UniqueName;

/**
 * {@code TopicCreateDto}, a DTO that specifies the validation rules to create a
 * topic.
 * 
 * @author Catherine Nobyn
 *
 */

public class TopicCreateDto {

	@UniqueName
	@NotBlank(message = "Veuillez saisir un nom de thématique")
	@Size(max = 45)
	private String name;

	public TopicCreateDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
