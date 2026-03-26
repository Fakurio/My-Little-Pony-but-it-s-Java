package com.unicorn.my_little_pony.domain.employees;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 2
// Klasa Caretaker reprezentuje pracownika odpowiedzialnego za opiekę nad jednorożcami. Otrzymuje komunikaty od mediatora i reaguje na nie, np. informując o potrzebie karmienia lub zabawy z kucykami.
public class Caretaker extends AbstractStableWorker {

    public Caretaker(StableMediator mediator) {
        super(mediator, "Caretaker");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 2