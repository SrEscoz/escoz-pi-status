package net.escoz.escozpistatus.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PiService {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;
	private String status;

	@Column(unique = true)
	private String url;

	private String comments;

}
