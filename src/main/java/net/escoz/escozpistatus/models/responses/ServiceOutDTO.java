package net.escoz.escozpistatus.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOutDTO {

	private long id;
	private String name;
	private String description;
	private String status;
	private String url;
	private String comments;

}
