package net.escoz.escozpistatus.services;

import net.escoz.escozpistatus.entities.PiService;

public interface PiServiceService {

	PiService getService(long id);

	PiService addService(PiService piService);
}
