package com.unicorn.my_little_pony.domain.models.unicorn.states;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Konkretny stan jednorożca
public class RentedState implements UnicornState {

    @Override
    public void rent(Unicorn context) {
        System.out.println("Błąd: Jednorożec jest aktualnie w trasie z innym klientem!");
    }

    @Override
    public void returnUnicorn(Unicorn context) {
        System.out.println("Jednorożec wraca do stajni. Zmiana stanu na: Wymaga Czyszczenia.");
        context.setUnicornState(new InMaintenanceState());
    }

    @Override
    public void clean(Unicorn context) {
        System.out.println("Błąd: Nie można czyścić jednorożca, którego tu nie ma.");
    }
}
// Koniec, Tydzień 6, Wzorzec State