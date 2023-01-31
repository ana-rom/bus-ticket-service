package ticketmanagementservice.dto.mapper;

import ticketmanagementservice.dto.request.BusTravelRequestDto;
import ticketmanagementservice.dto.response.BusTravelResponseDto;
import ticketmanagementservice.model.BusTravel;

public interface BusTravelMapper {
    BusTravel fromDto(BusTravelRequestDto dto);

    BusTravelResponseDto toDto(BusTravel busTravel);
}
