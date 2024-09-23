package net.escoz.escozpistatus.controllers;

import lombok.AllArgsConstructor;
import net.escoz.escozpistatus.entities.PiService;
import net.escoz.escozpistatus.entities.mappers.PiServiceMapper;
import net.escoz.escozpistatus.services.PiServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {

	private PiServiceService piServiceService;

	@RequestMapping("/")
	public String getIndex(Model model) {
		List<PiService> piServices = piServiceService.getAllServices();
		model.addAttribute("services", PiServiceMapper.INSTANCE.toDTOList(piServices));

		return "services-status";
	}

}
