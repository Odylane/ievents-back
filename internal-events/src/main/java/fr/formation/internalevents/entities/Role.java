package fr.formation.internalevents.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles", uniqueConstraints = { @UniqueConstraint(name = "UK_name", columnNames = { "name" }) })
public class Role extends AbstractEntity {

	@Column(length = 25, nullable = false, unique = true)
	private String name;

	@Convert(converter = BooleanConverter.class)
	@Column(length = 1, nullable = false)
	private boolean defaultRole;

	protected Role() {
		// Empty no-arg constructor for JPA
	}

	public Role(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;

	}

	public boolean isDefaultRole() {
		return defaultRole;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", defaultRole=" + defaultRole + "]";
	}
}
