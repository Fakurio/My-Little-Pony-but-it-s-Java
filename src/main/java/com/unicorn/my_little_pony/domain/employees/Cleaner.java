package com.unicorn.my_little_pony.domain.employees;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 2
// Klasa reprezentująca pracownika stajni, który zajmuje się sprzątaniem
public class Cleaner extends AbstractStableWorker {

    public Cleaner(StableMediator mediator) {
        super(mediator, "Cleaner");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 2