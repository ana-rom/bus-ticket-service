package ticketmanagementservice.service;

import java.util.List;
import ticketmanagementservice.model.BusTravel;
import ticketmanagementservice.model.Ticket;

public interface BusTravelService {
    BusTravel save(BusTravel busTravel);

    List<BusTravel> findAll();

    BusTravel findById(Long id);

    BusTravel update(BusTravel busTravel);

    void updateAvailableTickets(Ticket ticket);
}
