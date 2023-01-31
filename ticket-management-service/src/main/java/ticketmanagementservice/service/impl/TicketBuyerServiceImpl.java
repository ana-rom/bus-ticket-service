package ticketmanagementservice.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import ticketmanagementservice.model.Status;
import ticketmanagementservice.model.Ticket;
import ticketmanagementservice.repository.TicketRepository;
import ticketmanagementservice.service.BusTravelService;
import ticketmanagementservice.service.TicketBuyerService;

@Service
@Transactional
public class TicketBuyerServiceImpl implements TicketBuyerService {
    private final TicketRepository ticketRepository;
    private final BusTravelService busTravelService;
    private final WebClient webClient;

    public TicketBuyerServiceImpl(TicketRepository ticketRepository,
                                  BusTravelService busTravelService,
                                  WebClient webClient) {
        this.ticketRepository = ticketRepository;
        this.busTravelService = busTravelService;
        this.webClient = webClient;
    }

    @Override
    public Long buyTicket(Ticket ticket) {
        ticket.setStatus(createPaymentAndReceiveStatus(ticket));
        busTravelService.updateAvailableTickets(ticket);
        return save(ticket).getId();
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    private Status createPaymentAndReceiveStatus(Ticket ticket) {
        String clientName = ticket.getClientName();
        BigDecimal price = ticket.getPrice();
        return webClient.post()
                .uri("http://localhost:8080/payment", uriBuilder -> uriBuilder
                        .queryParam("clientName", clientName)
                        .queryParam("price", price)
                        .build())
                .retrieve()
                .bodyToMono(Status.class)
                .block();
    }
}
