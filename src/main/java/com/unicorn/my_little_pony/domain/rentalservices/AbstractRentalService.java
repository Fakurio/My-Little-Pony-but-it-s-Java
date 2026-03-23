package com.unicorn.my_little_pony.domain.rentalservices;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 3
// Abstrakcyjna klasa bazowa dla usług wynajmu, implementująca wspólne funkcjonalności
public abstract class AbstractRentalService implements RentalService {

    protected final ServiceMediator mediator;
    protected final String name;

    public AbstractRentalService(ServiceMediator mediator, String name) {
        if (mediator == null) {
            throw new IllegalArgumentException("Mediator cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Service name cannot be null or blank");
        }

        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 3