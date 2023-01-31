package ticketmanagementservice.dto.mapper;

import org.springframework.stereotype.Component;
import ticketmanagementservice.dto.request.BusTravelRequestDto;
import ticketmanagementservice.dto.response.BusTravelResponseDto;
import ticketmanagementservice.model.BusTravel;

@Component
public class BusTravelMapperImpl implements BusTravelMapper {
    @Override
    public BusTravel fromDto(BusTravelRequestDto dto) {
        BusTravel busTravel = new BusTravel();
        busTravel.setTo(dto.getTo());
        busTravel.setFrom(dto.getFrom());
        busTravel.setDepartureTime(dto.getDepartureTime());
        busTravel.setAvailableTickets(dto.getAvailableTickets());
        return busTravel;
    }

    @Override
    public BusTravelResponseDto toDto(BusTravel busTravel) {
        BusTravelResponseDto dto = new BusTravelResponseDto();
        dto.setId(busTravel.getId());
        dto.setFrom(busTravel.getFrom());
        dto.setTo(busTravel.getTo());
        dto.setDepartureTime(busTravel.getDepartureTime());
        dto.setAvailableTickets(busTravel.getAvailableTickets());
        return dto;
    }
}
