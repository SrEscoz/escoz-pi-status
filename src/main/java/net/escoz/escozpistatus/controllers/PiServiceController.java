package net.escoz.escozpistatus.controllers;

import lombok.AllArgsConstructor;
import net.escoz.escozpistatus.models.requests.PiServiceInDTO;
import net.escoz.escozpistatus.models.responses.PiServiceOutDTO;
import net.escoz.escozpistatus.services.PiServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/services")
@AllArgsConstructor
public class PiServiceController {
	private static final Logger LOG = LoggerFactory.getLogger(PiServiceController.class);

	private PiServiceService service;

	@PostMapping
	public PiServiceOutDTO createService(PiServiceInDTO piServiceInDTO) {
		LOG.info("Creating service: {}", piServiceInDTO);

		return new PiServiceOutDTO();
	}

}
