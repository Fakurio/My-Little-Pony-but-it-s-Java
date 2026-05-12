package com.unicorn.my_little_pony.domain.rentalsystem;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 1
// Klasa reprezentująca moduł systemu odpowiedzialny za obsługę płatności
public class PaymentModule extends AbstractSystemModule {

    public PaymentModule(SystemMediator mediator) {
        super(mediator, "PaymentModule");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 1