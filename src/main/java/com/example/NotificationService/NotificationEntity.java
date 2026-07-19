package com.example.NotificationService;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "notifications")
@Getter
@Setter
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private Long orderId;

    private String email;

    private String message;

    private String notificationType;

    private String status;

    private LocalDate createdDate;

    private LocalDate updatedDate;
}
