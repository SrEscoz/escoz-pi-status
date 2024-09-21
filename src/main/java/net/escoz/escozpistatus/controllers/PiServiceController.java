package net.escoz.escozpistatus.controllers;

import lombok.AllArgsConstructor;
import net.escoz.escozpistatus.entities.PiService;
import net.escoz.escozpistatus.entities.mappers.PiServiceMapper;
import net.escoz.escozpistatus.models.requests.PiServiceInDTO;
import net.escoz.escozpistatus.models.responses.PiServiceOutDTO;
import net.escoz.escozpistatus.services.PiServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/services")
@AllArgsConstructor
public class PiServiceController {
	private static final Logger LOG = LoggerFactory.getLogger(PiServiceController.class);

	private PiServiceService service;

	@PostMapping
	public ResponseEntity<PiServiceOutDTO> createService(@RequestBody PiServiceInDTO piServiceInDTO) {
		LOG.info("Creando un nuevo servicio -> {}", piServiceInDTO);

		PiService piService = service.createService(PiServiceMapper.INSTANCE.toEntity(piServiceInDTO));

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(PiServiceMapper.INSTANCE.toDTO(piService));
	}

}
