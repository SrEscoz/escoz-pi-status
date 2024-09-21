package net.escoz.escozpistatus.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

	private final static Logger LOG = LoggerFactory.getLogger(Utils.class);

	public static String objectToJson(Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);

		} catch (JsonProcessingException e) {
			LOG.error("Error al convertir el objeto a JSON -> {}", e.getMessage());
			return null;
		}
	}
}
