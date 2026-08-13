package com.example.NotificationService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(
            @RequestBody NotificationRequest request) {

        NotificationResponse response =
                service.createNotification(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getAllNotifications() {

        return ResponseEntity.ok(service.getAllNotifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponse> getNotification(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getNotification(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationResponse> updateNotification(
            @PathVariable Long id,
            @RequestBody NotificationRequest request) {

        return ResponseEntity.ok(
                service.updateNotification(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(
            @PathVariable Long id) {

        service.deleteNotification(id);

        return ResponseEntity.ok("Notification deleted successfully.");
    }
}