package paymentservice.service.impl;

import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import paymentservice.model.Payment;
import paymentservice.model.Status;
import paymentservice.service.PaymentCreationService;
import paymentservice.service.StatusReceiverService;

@Service
@Transactional
public class StatusReceiverServiceImpl implements StatusReceiverService {
    private final PaymentCreationService paymentCreationService;

    public StatusReceiverServiceImpl(PaymentCreationService paymentCreationService) {
        this.paymentCreationService = paymentCreationService;
    }

    @Override
    public Status receiveStatus(Long paymentId) {
        Payment payment = paymentCreationService.findById(paymentId);
        Status status = getRandomStatus();
        payment.setStatus(status);
        paymentCreationService.update(paymentCreationService.update(payment));
        return status;
    }

    private Status getRandomStatus() {
        int index = new Random().nextInt(Status.values().length);
        return Status.values()[index];
    }
}
