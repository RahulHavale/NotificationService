package com.example.NotificationService.consumer;

import com.example.NotificationService.NotificationEntity;
import com.example.NotificationService.NotificationRepository;
import com.example.NotificationService.PaymentEvent;
import org.springframework.kafka.annotation.KafkaListener;

import java.time.LocalDate;

public class NotificationConsumer {

    private final NotificationRepository repository;

    NotificationConsumer(NotificationRepository repository){
        this.repository = repository;
    }

    @KafkaListener(topics = "payment-topic", groupId = "notification-group")
    public void consumePaymentEvent(PaymentEvent paymentEvent) {

        System.out.println("Received Payment Event : " + paymentEvent);

        NotificationEntity entity = new NotificationEntity();

        entity.setOrderId(paymentEvent.orderId());

        // Temporary values since they are not present in PaymentEvent
        entity.setEmail("rahul@gmail.com");
        entity.setNotificationType("EMAIL");

        entity.setMessage("Payment Successful");

        entity.setCreatedDate(LocalDate.now());
        entity.setUpdatedDate(LocalDate.now());

        repository.save(entity);

        System.out.println("Notification Saved Successfully");
    }

}
