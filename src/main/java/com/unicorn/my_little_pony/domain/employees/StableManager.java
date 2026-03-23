package com.unicorn.my_little_pony.domain.employees;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 2
// Klasa reprezentująca pracownika stajni, który zarządza innymi pracownikami
public class StableManager extends AbstractStableWorker {

    public StableManager(StableMediator mediator) {
        super(mediator, "StableManager");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 2