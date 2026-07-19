package com.example.NotificationService;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NotificationResponse {

    private Long notificationId;

    private Long orderId;

    private String email;

    private String message;

    private String notificationType;

    private String status;

    private LocalDate createdDate;

    private LocalDate updatedDate;
}
