package net.escoz.escozpistatus.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Service {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;
	private String status;
	private String url;
	private String comments;

}
