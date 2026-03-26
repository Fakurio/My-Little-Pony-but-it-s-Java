package com.unicorn.my_little_pony.domain.employees;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 2
// Abstrakcyjna klasa reprezentująca pracownika stajni, który komunikuje się za pomocą mediatora.
public abstract class AbstractStableWorker implements StableWorker {

    protected final StableMediator mediator;
    protected final String name;

    public AbstractStableWorker(StableMediator mediator, String name) {
        if (mediator == null) {
            throw new IllegalArgumentException("Mediator cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Worker name cannot be null or blank");
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
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 2