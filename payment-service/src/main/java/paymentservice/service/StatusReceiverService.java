package paymentservice.service;

import paymentservice.model.Status;

public interface StatusReceiverService {
    Status receiveStatus(Long paymentId);
}
