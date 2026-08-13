package com.example.NotificationService;

import com.example.NotificationService.NotificationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;
    private final ModelMapper mapper;

    @Override
    public NotificationResponse createNotification(NotificationRequest request) {

        NotificationEntity entity = new NotificationEntity();

        entity.setOrderId(request.getOrderId());
        entity.setEmail(request.getEmail());
        entity.setMessage(request.getMessage());
        entity.setNotificationType(request.getNotificationType());

        entity.setStatus("SENT");
        entity.setCreatedDate(LocalDate.now());
        entity.setUpdatedDate(LocalDate.now());

        repository.save(entity);

        return mapper.map(entity, NotificationResponse.class);
    }

    @Override
    public List<NotificationResponse> getAllNotifications() {

        Type listType =
                new TypeToken<List<NotificationResponse>>() {
                }.getType();

        return mapper.map(repository.findAll(), listType);
    }

    @Override
    public NotificationResponse getNotification(Long id) {

        NotificationEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new NotificationNotFoundException(
                                "Notification not found with id : " + id));

        return mapper.map(entity, NotificationResponse.class);
    }

    @Override
    public NotificationResponse updateNotification(Long id,
                                                   NotificationRequest request) {

        NotificationEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new NotificationNotFoundException(
                                "Notification not found with id : " + id));

        entity.setOrderId(request.getOrderId());
        entity.setEmail(request.getEmail());
        entity.setMessage(request.getMessage());
        entity.setNotificationType(request.getNotificationType());
        entity.setUpdatedDate(LocalDate.now());

        repository.save(entity);

        return mapper.map(entity, NotificationResponse.class);
    }

    @Override
    public void deleteNotification(Long id) {

        if (!repository.existsById(id)) {
            throw new NotificationNotFoundException(
                    "Notification not found with id : " + id);
        }

        repository.deleteById(id);
    }
}