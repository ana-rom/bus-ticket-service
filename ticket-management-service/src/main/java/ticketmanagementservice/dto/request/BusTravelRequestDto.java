package ticketmanagementservice.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BusTravelRequestDto {
    private String from;
    private String to;
    private LocalDateTime departureTime;
    private Long availableTickets;
}
