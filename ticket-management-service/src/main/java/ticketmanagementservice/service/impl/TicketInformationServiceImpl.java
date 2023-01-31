package ticketmanagementservice.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ticketmanagementservice.dto.response.TicketInformationResponseDto;
import ticketmanagementservice.repository.TicketRepository;
import ticketmanagementservice.service.TicketInformationService;

@Service
@Transactional
public class TicketInformationServiceImpl implements TicketInformationService {
    private final TicketRepository ticketRepository;

    public TicketInformationServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketInformationResponseDto> getInformationAboutTicket(Long ticketId) {
        return ticketRepository.getTicketInformationByTicketId(ticketId);
    }
}
