package fr.formation.internalevents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "event_types", uniqueConstraints = { @UniqueConstraint(name = "UK_name", columnNames = { "name" }) })
public class EventType extends AbstractEntity {

	@Column(nullable = false, length = 45)
	private String name;

	public EventType() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
