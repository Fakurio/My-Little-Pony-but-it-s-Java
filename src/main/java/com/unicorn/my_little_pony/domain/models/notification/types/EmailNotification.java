package com.unicorn.my_little_pony.domain.models.notification.types;

// Tydzień 2, Wzorzec Simple factory
// Implementacja konkretnego typu powiadomienia
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
// Koniec, Tydzień 2, Wzorzec Simple factory