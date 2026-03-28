package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Konkretny stan zamówienia jednorożca
public class ConfirmedState implements OrderState {

    @Override
    public void submit(RentalOrder context) {
        System.out.println("Błąd: Zamówienie zostało już dawno zatwierdzone i opłacone.");
    }

    @Override
    public void pay(RentalOrder context) {
        System.out.println("Błąd: Płatność została już uregulowana.");
    }

    @Override
    public void cancel(RentalOrder context) {
        System.out.println("Anulowano opłacone zamówienie. Zmiana stanu na: Anulowane.");
        context.setState(new CancelledState());
    }
}
// Koniec, Tydzień 6, Wzorzec State