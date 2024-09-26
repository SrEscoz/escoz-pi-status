package net.escoz.escozpistatus.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		// Obtener el código de error
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		String errorMsg;
		int statusCode;

		if (status != null) {
			statusCode = Integer.parseInt(status.toString());

			errorMsg = switch (statusCode) {
				case 404 -> "Página no encontrada";
				case 500 -> "Error interno del servidor";
				case 403 -> "Acceso prohibido";
				default -> "Error inesperado";
			};

			model.addAttribute("status", statusCode);
			model.addAttribute("errorMsg", errorMsg);
		}

		return ERROR_PATH;
	}
}
