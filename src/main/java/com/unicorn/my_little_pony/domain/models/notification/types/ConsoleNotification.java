package com.unicorn.my_little_pony.domain.models.notification.types;

// Tydzień 2, Wzorzec Simple factory
// Implementacja konkretnego typu powiadomienia
public class ConsoleNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Console: " + message);
    }
}
// Koniec, Tydzień 2, Wzorzec Simple factory
