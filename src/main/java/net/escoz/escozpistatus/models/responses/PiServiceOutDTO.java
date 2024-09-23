package net.escoz.escozpistatus.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PiServiceOutDTO {

	private long id;
	private String name;
	private String description;
	private Boolean active;
	private Boolean hidden;
	private String url;

}
