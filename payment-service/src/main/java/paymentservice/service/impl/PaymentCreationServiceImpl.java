package paymentservice.service.impl;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import paymentservice.model.Payment;
import paymentservice.repository.PaymentRepository;
import paymentservice.service.PaymentCreationService;

@Service
@Transactional
public class PaymentCreationServiceImpl implements PaymentCreationService {
    private final PaymentRepository paymentRepository;

    public PaymentCreationServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Can't find payment by id " + id));
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }
}
