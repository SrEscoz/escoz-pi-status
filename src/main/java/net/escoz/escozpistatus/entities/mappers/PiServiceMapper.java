package net.escoz.escozpistatus.entities.mappers;

import net.escoz.escozpistatus.entities.PiService;
import net.escoz.escozpistatus.models.requests.PiServiceInDTO;
import net.escoz.escozpistatus.models.responses.PiServiceOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PiServiceMapper {

	PiServiceMapper INSTANCE = Mappers.getMapper(PiServiceMapper.class);

	@Mapping(target = "id", ignore = true)
	PiService toEntity(PiServiceInDTO piServiceInDTO);

	PiServiceOutDTO toDTO(PiService piService);

	List<PiServiceOutDTO> toDTOList(List<PiService> piServices);
}
