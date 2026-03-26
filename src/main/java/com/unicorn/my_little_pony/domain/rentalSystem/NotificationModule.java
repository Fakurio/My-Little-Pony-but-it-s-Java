package com.unicorn.my_little_pony.domain.rentalSystem;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 1
// Klasa reprezentująca moduł systemu odpowiedzialny za obsługę powiadomień
public class NotificationModule extends AbstractSystemModule {

    public NotificationModule(SystemMediator mediator) {
        super(mediator, "NotificationModule");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 1