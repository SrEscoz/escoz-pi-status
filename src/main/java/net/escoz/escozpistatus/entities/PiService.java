package net.escoz.escozpistatus.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "services")
public class PiService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private String status;

	@Column(unique = true)
	private String url;

	private String comments;

}
