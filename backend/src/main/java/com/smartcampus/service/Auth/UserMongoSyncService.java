package com.smartcampus.service.Auth;

import org.springframework.stereotype.Service;

import com.smartcampus.model.Auth.MongoUserDocument;
import com.smartcampus.model.Auth.User;
import com.smartcampus.repository.Auth.MongoUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMongoSyncService {
    private final MongoUserRepository mongoUserRepository;

    public void upsert(User user) {
        if (user == null || user.getId() == null) {
            return;
        }

        MongoUserDocument doc = mongoUserRepository.findBySqlUserId(user.getId())
                .orElseGet(MongoUserDocument::new);

        doc.setSqlUserId(user.getId());
        doc.setEmail(user.getEmail());
        doc.setName(user.getName());
        doc.setRole(user.getRole());
        doc.setPictureUrl(user.getPictureUrl());
        doc.setNotifyBookingUpdates(user.isNotifyBookingUpdates());
        doc.setNotifyTicketStatusChanges(user.isNotifyTicketStatusChanges());
        doc.setNotifyTicketComments(user.isNotifyTicketComments());
        doc.setNotificationPreferencesCustomized(user.isNotificationPreferencesCustomized());
        mongoUserRepository.save(doc);
    }

    public void deleteBySqlUserId(Long sqlUserId) {
        if (sqlUserId == null) {
            return;
        }
        mongoUserRepository.deleteBySqlUserId(sqlUserId);
    }
}
