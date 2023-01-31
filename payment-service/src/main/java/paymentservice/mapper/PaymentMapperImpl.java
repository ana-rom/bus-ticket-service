package paymentservice.mapper;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import paymentservice.model.Payment;

@Component
public class PaymentMapperImpl implements PaymentMapper {
    @Override
    public Payment toModel(String clientName, BigDecimal price) {
        Payment payment = new Payment();
        payment.setClientName(clientName);
        payment.setPrice(price);
        return payment;
    }
}
