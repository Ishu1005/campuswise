package com.smartcampus.model.Auth;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class MongoUserDocument {
    @Id
    private String id;

    @Indexed(unique = true)
    private Long sqlUserId;

    @Indexed(unique = true)
    private String email;

    private String name;
    private String role;
    private String pictureUrl;
    private boolean notifyBookingUpdates;
    private boolean notifyTicketStatusChanges;
    private boolean notifyTicketComments;
    private boolean notificationPreferencesCustomized;

    public String getId() {
        return id;
    }

    public Long getSqlUserId() {
        return sqlUserId;
    }

    public void setSqlUserId(Long sqlUserId) {
        this.sqlUserId = sqlUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public boolean isNotifyBookingUpdates() {
        return notifyBookingUpdates;
    }

    public void setNotifyBookingUpdates(boolean notifyBookingUpdates) {
        this.notifyBookingUpdates = notifyBookingUpdates;
    }

    public boolean isNotifyTicketStatusChanges() {
        return notifyTicketStatusChanges;
    }

    public void setNotifyTicketStatusChanges(boolean notifyTicketStatusChanges) {
        this.notifyTicketStatusChanges = notifyTicketStatusChanges;
    }

    public boolean isNotifyTicketComments() {
        return notifyTicketComments;
    }

    public void setNotifyTicketComments(boolean notifyTicketComments) {
        this.notifyTicketComments = notifyTicketComments;
    }

    public boolean isNotificationPreferencesCustomized() {
        return notificationPreferencesCustomized;
    }

    public void setNotificationPreferencesCustomized(boolean notificationPreferencesCustomized) {
        this.notificationPreferencesCustomized = notificationPreferencesCustomized;
    }
}
