package ticketmanagementservice.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BusTravelResponseDto {
    private Long id;
    private String from;
    private String to;
    private LocalDateTime departureTime;
    private Long availableTickets;
}
