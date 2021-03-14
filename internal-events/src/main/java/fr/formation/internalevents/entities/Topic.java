package fr.formation.internalevents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This class represents a {@code Topic} entity and it is mapped to a database
 * table.
 * <p>
 * The name of the database table {@code "topics"} is specified for the mapping.
 * 
 * @author Catherine Nobyn
 *
 */
@Entity
@Table(name = "topics", uniqueConstraints = { @UniqueConstraint(name = "UK_name", columnNames = { "name" }) })
public class Topic extends AbstractEntity {

	@Column(nullable = false, length = 45)
	private String name;

	public Topic() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
