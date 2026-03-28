package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Konkretny stan zamówienia jednorożca
public class DraftState implements OrderState {

    @Override
    public void submit(RentalOrder context) {
        System.out.println("Zamówienie złożone. Czekamy na płatność.");
        context.setState(new PendingPaymentState());
    }

    @Override
    public void pay(RentalOrder context) {
        System.out.println("Najpierw musisz złożyć zamówienie.");
    }

    @Override
    public void cancel(RentalOrder context) {
        System.out.println("Szkic usunięty.");
        context.setState(new CancelledState());
    }
}
// Koniec, Tydzień 6, Wzorzec State