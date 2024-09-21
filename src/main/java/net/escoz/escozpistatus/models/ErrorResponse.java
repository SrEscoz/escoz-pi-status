package net.escoz.escozpistatus.models;

import lombok.Builder;

@Builder
public record ErrorResponse(String timestamp, int status, String error) {
}

