package net.escoz.escozpistatus.services.impl;

import lombok.AllArgsConstructor;
import net.escoz.escozpistatus.entities.PiService;
import net.escoz.escozpistatus.exceptions.DuplicateEntityException;
import net.escoz.escozpistatus.repositories.PiServiceRepository;
import net.escoz.escozpistatus.services.PiServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PiServiceServiceImpl implements PiServiceService {

	private final static Logger LOG = LoggerFactory.getLogger(PiServiceServiceImpl.class);

	private PiServiceRepository serviceRepository;

	@Override
	public PiService createService(PiService piService) {

		// Comprobamos que no exista otra url igual
		serviceRepository.findByUrl(piService.getUrl())
				.ifPresent(e -> {
					LOG.error("Entidad duplicada -> Nombre: {} / URL: {}", piService.getName(), piService.getUrl());

					throw new DuplicateEntityException("Service '" + piService.getName()
							+ "' with the URL: " + piService.getUrl() + " already exists",
							new Throwable());
				});

		return serviceRepository.save(piService);
	}
}
