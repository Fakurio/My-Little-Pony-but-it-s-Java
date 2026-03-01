package com.unicorn.my_little_pony.domain.models.notification.types;

// Tydzień 2, Wzorzec Simple factory
// Wspólny interfejs dla wszystkich powiadomień tworzonych w fabryce
public interface Notification {
    void send(String message);
}
// Koniec, Tydzień 2, Wzorzec Simple factory