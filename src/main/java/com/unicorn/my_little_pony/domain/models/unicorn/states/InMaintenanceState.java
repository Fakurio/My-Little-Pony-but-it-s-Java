package com.unicorn.my_little_pony.domain.models.unicorn.states;

import com.unicorn.my_little_pony.domain.exceptions.InvalidStateTransitionException;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Konkretny stan jednorożca
public class InMaintenanceState implements UnicornState {

    @Override
    public void rent(UnicornContext context) {
        throw new InvalidStateTransitionException("Unicorn must be cleaned before it can be rented.");
    }

    @Override
    public void returnUnicorn(UnicornContext context) {
        throw new InvalidStateTransitionException("Unicorn has already been returned.");
    }

    @Override
    public void clean(UnicornContext context) {
        System.out.println("Stajenny wyczyścił jednorożca! Zmiana stanu na: Dostępny.");
        context.setState(new AvailableState());
    }
}
// Koniec, Tydzień 6, Wzorzec State
