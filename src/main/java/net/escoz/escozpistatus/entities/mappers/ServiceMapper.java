package net.escoz.escozpistatus.entities.mappers;

import net.escoz.escozpistatus.entities.Service;
import net.escoz.escozpistatus.models.requests.ServiceInDTO;
import net.escoz.escozpistatus.models.responses.ServiceOutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceMapper {

	ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

	@Mapping(target = "id", ignore = true)
	Service toEntity(ServiceInDTO serviceInDTO);

	ServiceOutDTO toDTO(Service service);

}
