package fr.formation.internalevents.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TopicCreateDto {
	
	@NotBlank
	@Size(max=45)
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
