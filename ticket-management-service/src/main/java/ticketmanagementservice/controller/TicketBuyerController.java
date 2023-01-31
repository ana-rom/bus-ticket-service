package ticketmanagementservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ticketmanagementservice.dto.mapper.TicketMapper;
import ticketmanagementservice.dto.request.TicketRequestDto;
import ticketmanagementservice.dto.response.TicketInformationResponseDto;
import ticketmanagementservice.service.TicketBuyerService;
import ticketmanagementservice.service.TicketInformationService;

@RestController
@RequestMapping("/tickets")
public class TicketBuyerController {
    private final TicketBuyerService ticketBuyerService;
    private final TicketInformationService ticketInformationService;
    private final TicketMapper ticketMapper;

    public TicketBuyerController(TicketBuyerService ticketBuyerService,
                                 TicketInformationService ticketInformationService,
                                 TicketMapper ticketMapper) {
        this.ticketBuyerService = ticketBuyerService;
        this.ticketInformationService = ticketInformationService;
        this.ticketMapper = ticketMapper;
    }

    @PostMapping
    public Long buyTicket(@RequestBody TicketRequestDto dto) {
        return ticketBuyerService.buyTicket(ticketMapper.fromDto(dto));
    }

    @GetMapping("/{id}/information")
    public List<TicketInformationResponseDto> getInformationAboutTicket(@PathVariable Long id) {
        return ticketInformationService.getInformationAboutTicket(id);
    }
}
