package com.unicorn.my_little_pony.domain.models.unicorn.states;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Konkretny stan jednorożca
public class AvailableState implements UnicornState {

    @Override
    public void rent(Unicorn context) {
        System.out.println("Wypożyczono jednorożca! Zmiana stanu na: Wypożyczony.");
        context.setUnicornState(new RentedState());
    }

    @Override
    public void returnUnicorn(Unicorn context) {
        System.out.println("Błąd: Jednorożec jest już w stajni, nie można go zwrócić.");
    }

    @Override
    public void clean(Unicorn context) {
        System.out.println("Jednorożec jest już czysty i gotowy do drogi.");
    }
}
// Koniec, Tydzień 6, Wzorzec State