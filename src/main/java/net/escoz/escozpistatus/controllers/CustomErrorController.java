package net.escoz.escozpistatus.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	private final ErrorAttributes errorAttributes;

	public CustomErrorController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, WebRequest webRequest, Model model) {
		// Obtener el código de error
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

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
