package net.escoz.escozpistatus.services.impl;

import lombok.AllArgsConstructor;
import net.escoz.escozpistatus.entities.PiService;
import net.escoz.escozpistatus.repositories.PiServiceRepository;
import net.escoz.escozpistatus.services.PiServiceService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PiServiceServiceImpl implements PiServiceService {

	private PiServiceRepository serviceRepository;

	@Override
	public PiService createService(PiService piService) {

		return serviceRepository.save(piService);
	}
}
