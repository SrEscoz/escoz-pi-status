package net.escoz.escozpistatus.controllers;

import net.escoz.escozpistatus.exceptions.DuplicateEntityException;
import net.escoz.escozpistatus.exceptions.InvalidArgumentException;
import net.escoz.escozpistatus.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler({DuplicateEntityException.class})
	protected ResponseEntity<ErrorResponse> handleDuplicatedEntityException(DuplicateEntityException exception) {

		ErrorResponse response = ErrorResponse.builder()
				.timestamp(Instant.now().toString())
				.status(HttpStatus.CONFLICT.value())
				.error(exception.getMessage())
				.build();

		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(response);

	}

	@ExceptionHandler({InvalidArgumentException.class})
	protected ResponseEntity<ErrorResponse> handleInvalidArgumentException(InvalidArgumentException exception) {

		ErrorResponse response = ErrorResponse.builder()
				.timestamp(Instant.now().toString())
				.status(HttpStatus.BAD_REQUEST.value())
				.error(exception.getMessage())
				.build();

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}
}
