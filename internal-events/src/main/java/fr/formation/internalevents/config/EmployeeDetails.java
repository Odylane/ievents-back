package fr.formation.internalevents.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import fr.formation.internalevents.dtos.EmployeeAuthDto;
import fr.formation.internalevents.entities.Role;

/**
 * A custom {@code EmployeeDetails} for Spring authentication contract and
 * custom properties available in the token (such as the id).
 */
public class EmployeeDetails extends User {

	private static final long serialVersionUID = 5803283930339051994L;

	private Long id;

	public EmployeeDetails(EmployeeAuthDto user) {
		super(user.getUsername(), user.getPassword(), buildAuthorities(user.getRoles()));
		id = user.getId();
	}

	private static Set<GrantedAuthority> buildAuthorities(Set<Role> roles) {
		return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toUnmodifiableSet());
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", authorities=" + getAuthorities() + ", password=[PROTECTED], username=" + getUsername()
				+ "}";
	}

}
