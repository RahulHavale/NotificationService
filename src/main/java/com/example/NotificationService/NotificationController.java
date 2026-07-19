package com.example.NotificationService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public void createNotification(
            @RequestBody NotificationRequest request) {

        service.createNotification(request);
    }

    @GetMapping
    public List<NotificationResponse> getAllNotifications() {

        return service.getAllNotifications();
    }

    @GetMapping("/{id}")
    public NotificationResponse getNotification(
            @PathVariable Long id) {

        return service.getNotification(id);
    }

    @PutMapping("/{id}")
    public void updateNotification(
            @PathVariable Long id,
            @RequestBody NotificationRequest request) {

        service.updateNotification(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(
            @PathVariable Long id) {

        service.deleteNotification(id);
    }
}
