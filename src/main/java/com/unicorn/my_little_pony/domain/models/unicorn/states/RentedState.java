package com.unicorn.my_little_pony.domain.models.unicorn.states;

import com.unicorn.my_little_pony.domain.exceptions.InvalidStateTransitionException;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Konkretny stan jednorożca
public class RentedState implements UnicornState {

    @Override
    public void rent(UnicornContext context) {
        throw new InvalidStateTransitionException("Unicorn is already rented by another customer.");
    }

    @Override
    public void returnUnicorn(UnicornContext context) {
        System.out.println("Jednorożec wraca do stajni. Zmiana stanu na: Wymaga Czyszczenia.");
        context.setState(new InMaintenanceState());
    }

    @Override
    public void clean(UnicornContext context) {
        throw new InvalidStateTransitionException("Cannot clean a unicorn that has not returned yet.");
    }
}
// Koniec, Tydzień 6, Wzorzec State
