package ticketmanagementservice.dto.response;

import java.time.LocalDateTime;

public interface TicketInformationResponseDto {
    Long getBusTravelId();

    String getFromDestination();

    String getToDestination();

    LocalDateTime getDepartureTime();

    Long getAvailableTickets();

    Long getTicketId();

    String getClientName();

    String getStatus();
}
