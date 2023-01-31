package ticketmanagementservice.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TicketRequestDto {
    private String clientName;
    private Long busTravelId;
    private BigDecimal price;
}
