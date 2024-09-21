package net.escoz.escozpistatus.services;

import net.escoz.escozpistatus.entities.PiService;

import java.util.List;

public interface PiServiceService {

	List<PiService> getAllServices();

	PiService getService(long id);

	PiService addService(PiService piService);

	PiService updateService(long id, PiService entity);

	void deleteService(long id);

}
