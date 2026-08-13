package com.example.NotificationService;

public record PaymentEvent(  Long paymentId,
                             Long orderId,
                             Double amount,
                             String paymentStatus) {
}
