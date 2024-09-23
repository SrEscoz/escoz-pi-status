package net.escoz.escozpistatus.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PiServiceInDTO {

	@NotBlank
	private String name;

	private String description;

	private Boolean active;

	private Boolean hidden;

	@NotBlank
	private String url;

}
