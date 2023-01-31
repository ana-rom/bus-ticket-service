package paymentservice.service;

import paymentservice.model.Payment;

public interface PaymentCreationService {
    Payment save(Payment payment);

    Payment findById(Long id);

    Payment update(Payment payment);
}
