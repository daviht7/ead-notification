package com.ead.notification.services.impl;

import com.ead.notification.models.NotificationModel;
import com.ead.notification.models.NotificationStatus;
import com.ead.notification.repositories.NotificationRepository;
import com.ead.notification.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void saveNotification(NotificationModel notificationModel) {
        notificationRepository.save(notificationModel);
    }

    @Override
    public Page<NotificationModel> findAllNotificationByUser(UUID userId, Pageable pageable) {
        return notificationRepository.findAllByUserIdAndNotificationStatus(userId, NotificationStatus.CREATED, pageable);
    }

    @Override
    public Optional<NotificationModel> findByNotificationIdAndUserId(UUID notificationId, UUID userId) {
        return notificationRepository.findByNotificationIdAndUserId(notificationId, userId);
    }
}
