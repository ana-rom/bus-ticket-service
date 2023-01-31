package paymentservice.mapper;

import java.math.BigDecimal;
import paymentservice.model.Payment;

public interface PaymentMapper {
    Payment toModel(String clientName, BigDecimal price);
}
