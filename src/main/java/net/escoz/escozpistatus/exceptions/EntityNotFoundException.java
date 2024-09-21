package net.escoz.escozpistatus.exceptions;

public class EntityNotFoundException extends RuntimeException {
	public EntityNotFoundException(String entity) {
		super("Entity with id: " + entity + " not found");
	}
}
