package com.unicorn.my_little_pony.domain.rentalSystem;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 1
// Abstrakcyjna klasa bazowa dla modułów systemu, implementująca wspólne funkcjonalności
public abstract class AbstractSystemModule implements SystemModule {

    protected final SystemMediator mediator;
    protected final String name;

    public AbstractSystemModule(SystemMediator mediator, String name) {
        if (mediator == null) {
            throw new IllegalArgumentException("Mediator cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Module name cannot be null or blank");
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
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 1