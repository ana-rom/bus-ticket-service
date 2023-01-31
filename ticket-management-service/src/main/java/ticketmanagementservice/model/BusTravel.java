package ticketmanagementservice.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bus_travels")
public class BusTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "destination_from")
    private String from;
    @Column(name = "destination_to")
    private String to;
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    @Column(name = "amount_of_available_tickets")
    private Long availableTickets;
}
