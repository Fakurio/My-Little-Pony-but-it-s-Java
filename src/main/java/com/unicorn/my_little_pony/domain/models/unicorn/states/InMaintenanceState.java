package com.unicorn.my_little_pony.domain.models.unicorn.states;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Konkretny stan jednorożca
public class InMaintenanceState implements UnicornState {

    @Override
    public void rent(Unicorn context) {
        System.out.println("Błąd: Jednorożec musi najpierw zostać wyczyszczony.");
    }

    @Override
    public void returnUnicorn(Unicorn context) {
        System.out.println("Błąd: Jednorożec został już zwrócony.");
    }

    @Override
    public void clean(Unicorn context) {
        System.out.println("Stajenny wyczyścił jednorożca! Zmiana stanu na: Dostępny.");
        context.setUnicornState(new AvailableState());
    }
}
// Koniec, Tydzień 6, Wzorzec State