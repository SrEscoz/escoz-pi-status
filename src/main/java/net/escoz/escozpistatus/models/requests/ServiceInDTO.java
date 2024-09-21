package net.escoz.escozpistatus.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInDTO {

	private String name;
	private String description;
	private String status;
	private String url;
	private String comments;
}
