package fr.formation.internalevents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "rooms", uniqueConstraints = {
		@UniqueConstraint(name = "UK_name", columnNames = { "name" }) }, indexes = {
				@Index(name = "fk_rooms_building_idx", columnList = "building_id") })
public class Room extends AbstractEntity {

	@Column(nullable = false, length = 45)
	private String name;

	@Column(nullable = false)
	private int capacity;

	@ManyToOne
	@JoinColumn(nullable = false, name = "building_id", foreignKey = @ForeignKey(name = "fk_rooms_buildings"))
	private Building building;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", capacity=" + capacity + ", building=" + building + "]";
	}

}
