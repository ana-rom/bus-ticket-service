package ticketmanagementservice.service;

import java.util.List;
import ticketmanagementservice.dto.response.TicketInformationResponseDto;

public interface TicketInformationService {
    List<TicketInformationResponseDto> getInformationAboutTicket(Long ticketId);
}
