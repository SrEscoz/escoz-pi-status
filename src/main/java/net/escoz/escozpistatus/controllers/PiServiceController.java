package net.escoz.escozpistatus.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.escoz.escozpistatus.entities.PiService;
import net.escoz.escozpistatus.entities.mappers.PiServiceMapper;
import net.escoz.escozpistatus.exceptions.InvalidArgumentException;
import net.escoz.escozpistatus.models.BasicResponse;
import net.escoz.escozpistatus.models.requests.PiServiceInDTO;
import net.escoz.escozpistatus.models.responses.PiServiceOutDTO;
import net.escoz.escozpistatus.services.PiServiceService;
import net.escoz.escozpistatus.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/services")
@AllArgsConstructor
public class PiServiceController {
	private static final Logger LOG = LoggerFactory.getLogger(PiServiceController.class);

	private PiServiceService service;

	@GetMapping
	public ResponseEntity<List<PiServiceOutDTO>> getAllServices() {

		LOG.info("Obtención de todos los servicios");
		List<PiService> services = service.getAllServices();

		return ResponseEntity
				.ok()
				.body(PiServiceMapper.INSTANCE.toDTOList(services));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PiServiceOutDTO> getService(@PathVariable long id) {

		LOG.info("Obtención del servicio con id -> {}", id);
		PiService piService = service.getService(id);

		return ResponseEntity
				.ok()
				.body(PiServiceMapper.INSTANCE.toDTO(piService));
	}

	@PostMapping
	public ResponseEntity<PiServiceOutDTO> addService(@RequestBody @Valid PiServiceInDTO piServiceInDTO,
													  BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			String field = Objects.requireNonNull(bindingResult.getFieldError()).getField();
			throw new InvalidArgumentException(field);
		}

		LOG.info("Creando un nuevo servicio -> {}", Utils.objectToJson(piServiceInDTO));
		PiService piService = service.addService(PiServiceMapper.INSTANCE.toEntity(piServiceInDTO));

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(PiServiceMapper.INSTANCE.toDTO(piService));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicResponse> deleteService(@PathVariable long id) {

		LOG.info("Eliminando el servicio con id -> {}", id);
		service.deleteService(id);

		return ResponseEntity
				.ok()
				.body(new BasicResponse("The service was deleted"));
	}

}
