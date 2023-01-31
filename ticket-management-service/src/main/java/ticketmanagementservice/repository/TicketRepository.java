package ticketmanagementservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ticketmanagementservice.dto.response.TicketInformationResponseDto;
import ticketmanagementservice.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "SELECT bt.id as bustravelid, "
            + "bt.destination_from as fromdestination, "
            + "bt.destination_to as todestination, "
            + "bt.departure_time as departuretime, "
            + "bt.amount_of_available_tickets as availabletickets,  "
            + "t.id as ticketid, "
            + "t.client_name as clientname, "
            + "t.status "
            + "FROM tickets t "
            + "JOIN bus_travels bt "
            + "ON t.bus_travel_id = bt.id "
            + "WHERE t.id = :id",
            nativeQuery = true)
    List<TicketInformationResponseDto> getTicketInformationByTicketId(@Param("id") Long id);
}
