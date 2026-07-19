package com.example.NotificationService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl
        implements NotificationService {

    private final NotificationRepository repository;

    private final ModelMapper mapper;

    @Override
    public void createNotification(NotificationRequest request) {


        NotificationEntity entity = new NotificationEntity();

        entity.setOrderId(request.getOrderId());
        entity.setEmail(request.getEmail());
        entity.setMessage(request.getMessage());
        entity.setNotificationType(request.getNotificationType());

        entity.setStatus("SENT");
        entity.setCreatedDate(LocalDate.now());
        entity.setUpdatedDate(LocalDate.now());

        repository.save(entity);
    }

    @Override
    public List<NotificationResponse> getAllNotifications() {

        Type listType =
                new TypeToken<List<NotificationResponse>>() {}.getType();

        return mapper.map(repository.findAll(), listType);
    }

    @Override
    public NotificationResponse getNotification(Long id) {

        NotificationEntity entity =
                repository.findById(id).orElse(null);

        if (entity == null)
            return null;

        return mapper.map(entity, NotificationResponse.class);
    }

    @Override
    public void updateNotification(Long id,
                                   NotificationRequest request) {

        NotificationEntity entity =
                repository.findById(id).orElse(null);

        if (entity == null)
            return;

        entity.setOrderId(request.getOrderId());
        entity.setEmail(request.getEmail());
        entity.setMessage(request.getMessage());
        entity.setNotificationType(request.getNotificationType());
        entity.setUpdatedDate(LocalDate.now());

        repository.save(entity);
    }

    @Override
    public void deleteNotification(Long id) {

        repository.deleteById(id);
    }
}
