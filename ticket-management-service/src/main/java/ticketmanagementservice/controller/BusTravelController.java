package ticketmanagementservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ticketmanagementservice.dto.mapper.BusTravelMapper;
import ticketmanagementservice.dto.request.BusTravelRequestDto;
import ticketmanagementservice.dto.response.BusTravelResponseDto;
import ticketmanagementservice.model.BusTravel;
import ticketmanagementservice.service.BusTravelService;

@RestController
@RequestMapping("/bus-travels")
public class BusTravelController {
    private final BusTravelMapper busTravelMapper;
    private final BusTravelService busTravelService;

    public BusTravelController(BusTravelMapper busTravelMapper,
                               BusTravelService busTravelService) {
        this.busTravelMapper = busTravelMapper;
        this.busTravelService = busTravelService;
    }

    @PostMapping
    public BusTravelResponseDto createBusTravel(@RequestBody BusTravelRequestDto dto) {
        BusTravel savedBusTravel = busTravelService.save(busTravelMapper.fromDto(dto));
        return busTravelMapper.toDto(savedBusTravel);
    }

    @GetMapping
    public List<BusTravelResponseDto> findAllBusTravels() {
        return busTravelService.findAll().stream()
                .map(busTravelMapper::toDto)
                .toList();
    }
}
