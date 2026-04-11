package com.unicorn.my_little_pony.domain.models.unicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Konkretny stan jednorożca
public class InMaintenanceState implements UnicornState {

    @Override
    public void rent(UnicornContext context) {
        System.out.println("Błąd: Jednorożec musi najpierw zostać wyczyszczony.");
    }

    @Override
    public void returnUnicorn(UnicornContext context) {
        System.out.println("Błąd: Jednorożec został już zwrócony.");
    }

    @Override
    public void clean(UnicornContext context) {
        System.out.println("Stajenny wyczyścił jednorożca! Zmiana stanu na: Dostępny.");
        context.setState(new AvailableState());
    }
}
// Koniec, Tydzień 6, Wzorzec State