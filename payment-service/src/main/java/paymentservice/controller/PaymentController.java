package paymentservice.controller;

import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import paymentservice.mapper.PaymentMapper;
import paymentservice.model.Payment;
import paymentservice.model.Status;
import paymentservice.service.PaymentCreationService;
import paymentservice.service.StatusReceiverService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentMapper paymentMapper;
    private final PaymentCreationService paymentService;
    private final StatusReceiverService statusReceiverService;

    public PaymentController(PaymentMapper paymentMapper,
                             PaymentCreationService paymentCreationService,
                             StatusReceiverService statusReceiverService) {
        this.paymentMapper = paymentMapper;
        this.paymentService = paymentCreationService;
        this.statusReceiverService = statusReceiverService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Status createPaymentAndReceiveStatus(@RequestParam String clientName,
                                                @RequestParam BigDecimal price) {
        Payment savedPayment = paymentService.save(paymentMapper.toModel(clientName, price));
        return statusReceiverService.receiveStatus(savedPayment.getId());
    }
}
