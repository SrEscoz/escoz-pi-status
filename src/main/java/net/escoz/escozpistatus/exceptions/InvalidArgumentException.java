package net.escoz.escozpistatus.exceptions;

public class InvalidArgumentException extends RuntimeException {
	public InvalidArgumentException(String field) {
		super("Invalid argument: " + field);
	}
}
