package net.escoz.escozpistatus.dto;

import lombok.Builder;

@Builder
public record ErrorResponse(String timestamp, int status, String error) {
}

