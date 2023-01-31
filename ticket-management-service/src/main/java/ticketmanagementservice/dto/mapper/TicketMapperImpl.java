package ticketmanagementservice.dto.mapper;

import org.springframework.stereotype.Component;
import ticketmanagementservice.dto.request.TicketRequestDto;
import ticketmanagementservice.model.Ticket;
import ticketmanagementservice.service.BusTravelService;

@Component
public class TicketMapperImpl implements TicketMapper {
    private final BusTravelService busTravelService;

    public TicketMapperImpl(BusTravelService busTravelService) {
        this.busTravelService = busTravelService;
    }

    @Override
    public Ticket fromDto(TicketRequestDto dto) {
        Ticket ticket = new Ticket();
        ticket.setClientName(dto.getClientName());
        ticket.setBusTravel(busTravelService.findById(dto.getBusTravelId()));
        ticket.setPrice(dto.getPrice());
        return ticket;
    }
}
