package com.example.NotificationService;

import java.util.List;

public interface NotificationService {

    NotificationResponse createNotification(
            NotificationRequest request);

    List<NotificationResponse> getAllNotifications();

    NotificationResponse getNotification(Long id);

    NotificationResponse updateNotification(
            Long id,
            NotificationRequest request);

    void deleteNotification(Long id);
}
