package com.example.NotificationService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {

    private Long orderId;

    private String email;

    private String message;

    private String notificationType;
}
