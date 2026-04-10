package com.unicorn.my_little_pony.domain.models.unicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Konkretny stan jednorożca
public class AvailableState implements UnicornState {

    @Override
    public void rent(UnicornContext context) {
        System.out.println("Wypożyczono jednorożca! Zmiana stanu na: Wypożyczony.");
        context.setState(new RentedState());
    }

    @Override
    public void returnUnicorn(UnicornContext context) {
        System.out.println("Błąd: Jednorożec jest już w stajni, nie można go zwrócić.");
    }

    @Override
    public void clean(UnicornContext context) {
        System.out.println("Jednorożec jest już czysty i gotowy do drogi.");
    }
}
// Koniec, Tydzień 6, Wzorzec State