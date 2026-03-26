package com.unicorn.my_little_pony.domain.rentalSystem;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 1
// Klasa reprezentująca moduł systemu odpowiedzialny za obsługę dostępności rogatych kucy
public class AvailabilityModule extends AbstractSystemModule {

    public AvailabilityModule(SystemMediator mediator) {
        super(mediator, "AvailabilityModule");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 1