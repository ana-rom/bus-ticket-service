package ticketmanagementservice.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ticketmanagementservice.model.BusTravel;
import ticketmanagementservice.model.Ticket;
import ticketmanagementservice.repository.BusTravelRepository;
import ticketmanagementservice.service.BusTravelService;

@Service
@Transactional
public class BusTravelServiceImpl implements BusTravelService {
    private static final long TICKET_AMOUNT = 1L;
    private final BusTravelRepository busTravelRepository;

    public BusTravelServiceImpl(BusTravelRepository busTravelRepository) {
        this.busTravelRepository = busTravelRepository;
    }

    @Override
    public BusTravel save(BusTravel busTravel) {
        return busTravelRepository.save(busTravel);
    }

    @Override
    public List<BusTravel> findAll() {
        return busTravelRepository.findAll();
    }

    @Override
    public BusTravel findById(Long id) {
        return busTravelRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Can't find bus travel by id " + id));
    }

    @Override
    public BusTravel update(BusTravel busTravel) {
        return busTravelRepository.save(busTravel);
    }

    @Override
    public void updateAvailableTickets(Ticket ticket) {
        BusTravel busTravel = findById(ticket.getBusTravel().getId());
        if (isTicketAvailable(busTravel)) {
            busTravel.setAvailableTickets(busTravel.getAvailableTickets() - TICKET_AMOUNT);
            update(busTravel);
        } else {
            throw new IllegalArgumentException("There is no available tickets for bus travel "
                    + "with id " + busTravel.getId());
        }
    }

    private Boolean isTicketAvailable(BusTravel busTravel) {
        return busTravel.getAvailableTickets() > 0;
    }
}
