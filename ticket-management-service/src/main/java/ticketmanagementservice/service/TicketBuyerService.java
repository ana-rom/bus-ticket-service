package ticketmanagementservice.service;

import ticketmanagementservice.model.Ticket;

public interface TicketBuyerService {
    Long buyTicket(Ticket ticket);

    Ticket save(Ticket ticket);
}
