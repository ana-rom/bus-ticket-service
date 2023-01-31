package ticketmanagementservice.dto.mapper;

import ticketmanagementservice.dto.request.TicketRequestDto;
import ticketmanagementservice.model.Ticket;

public interface TicketMapper {
    Ticket fromDto(TicketRequestDto dto);
}
