package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.exceptions.InvalidStateTransitionException;
import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Konkretny stan zamówienia jednorożca
public class ConfirmedState implements OrderState {

    @Override
    public void submit(RentalOrderContext context) {
        throw new InvalidStateTransitionException("Order has already been confirmed and paid.");
    }

    @Override
    public void pay(RentalOrderContext context) {
        throw new InvalidStateTransitionException("Payment has already been completed.");
    }

    @Override
    public void cancel(RentalOrderContext context) {
        System.out.println("Anulowano opłacone zamówienie. Zmiana stanu na: Anulowane.");
        context.setState(new CancelledState());
    }
}
// Koniec, Tydzień 6, Wzorzec State
