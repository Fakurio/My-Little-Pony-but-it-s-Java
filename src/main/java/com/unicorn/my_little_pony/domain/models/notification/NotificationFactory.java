package com.unicorn.my_little_pony.domain.models.notification;

import com.unicorn.my_little_pony.domain.models.notification.types.ConsoleNotification;
import com.unicorn.my_little_pony.domain.models.notification.types.EmailNotification;
import com.unicorn.my_little_pony.domain.models.notification.types.Notification;
import com.unicorn.my_little_pony.domain.models.notification.types.SmsNotification;
import com.unicorn.my_little_pony.enums.NotificationType;

// Tydzień 2, Wzorzec Simple factory, Zastosowanie 1
// Fabryka powiadomień z jedną metodą która zwraca obiekty o wspólnym interfejsie
public class NotificationFactory {

    public static Notification createNotification(NotificationType type) {
        return switch (type) {
            case SMS -> new SmsNotification();
            case EMAIL -> new EmailNotification();
            case CONSOLE -> new ConsoleNotification();
            default -> throw new IllegalArgumentException("Unknown notification type");
        };
    }
}
// Koniec, Tydzień 2, Wzorzec Simple factory, Zastosowanie 1
