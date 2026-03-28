package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Konkretny stan zamówienia jednorożca
public class PendingPaymentState implements OrderState {

    @Override
    public void submit(RentalOrder context) {
        System.out.println("Zamówienie zostało już złożone.");
    }

    @Override
    public void pay(RentalOrder context) {
        System.out.println("Płatność zaakceptowana! Rezerwacja potwierdzona.");
        context.setState(new ConfirmedState());
    }

    @Override
    public void cancel(RentalOrder context) {
        System.out.println("Anulowano nieopłacone zamówienie.");
        context.setState(new CancelledState());
    }
}
// Koniec, Tydzień 6, Wzorzec State