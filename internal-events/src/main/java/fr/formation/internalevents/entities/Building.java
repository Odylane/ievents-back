package fr.formation.internalevents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This class represents a {@code Building} entity and it is mapped to a
 * database.
 * <p>
 * The name of the database table {@code "buildings"} is specified for the
 * mapping.
 * 
 * @author Catherine Nobyn
 *
 */
@Entity
@Table(name = "buildings", uniqueConstraints = { @UniqueConstraint(name = "UK_name", columnNames = "name") })
public class Building extends AbstractEntity {

	@Column(nullable = false, length = 45, unique = true)
	private String name;

	public Building() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
