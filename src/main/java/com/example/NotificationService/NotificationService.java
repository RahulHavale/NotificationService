package com.example.NotificationService;

import java.util.List;

public interface NotificationService {

    void createNotification(NotificationRequest request);

    List<NotificationResponse> getAllNotifications();

    NotificationResponse getNotification(Long id);

    void updateNotification(Long id,
                            NotificationRequest request);

    void deleteNotification(Long id);
}
