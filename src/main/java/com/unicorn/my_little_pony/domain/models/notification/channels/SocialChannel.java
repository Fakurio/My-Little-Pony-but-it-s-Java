package com.unicorn.my_little_pony.domain.models.notification.channels;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 2
// Interfejs dla wszystkich klas implementujących wysyłania powiadomień przez social media
public interface SocialChannel {
    void sendMessage(String accountId, String message);
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 2