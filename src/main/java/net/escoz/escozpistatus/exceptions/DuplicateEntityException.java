package net.escoz.escozpistatus.exceptions;

public class DuplicateEntityException extends RuntimeException {
	public DuplicateEntityException(String entity) {
		super("The Entity '" + entity + "' already exists");
	}

	public DuplicateEntityException(String message, Throwable cause) {
		super(message, cause);
	}
}
