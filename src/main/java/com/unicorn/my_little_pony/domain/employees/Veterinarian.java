package com.unicorn.my_little_pony.domain.employees;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 2
// Klasa reprezentująca pracownika stajni, który zajmuje się leczeniem
public class Veterinarian extends AbstractStableWorker {

    public Veterinarian(StableMediator mediator) {
        super(mediator, "Veterinarian");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 2