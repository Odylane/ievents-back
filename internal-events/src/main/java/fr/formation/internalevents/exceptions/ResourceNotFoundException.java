package fr.formation.internalevents.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4431015264194259154L;

	public ResourceNotFoundException(String message) {
		super(message);

	}
}
