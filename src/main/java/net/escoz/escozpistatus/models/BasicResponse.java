package net.escoz.escozpistatus.models;

public record BasicResponse(int status, String message) {

	public BasicResponse(String message) {
		this(200, message);
	}
}
