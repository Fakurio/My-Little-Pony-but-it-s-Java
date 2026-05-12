package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.exceptions.InvalidStateTransitionException;
import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Konkretny stan zamówienia jednorożca
public class CancelledState implements OrderState {

    @Override
    public void submit(RentalOrderContext context) {
        throw new InvalidStateTransitionException("Cannot submit a cancelled order.");
    }

    @Override
    public void pay(RentalOrderContext context) {
        throw new InvalidStateTransitionException("Cannot pay for a cancelled order.");
    }

    @Override
    public void cancel(RentalOrderContext context) {
        throw new InvalidStateTransitionException("Order has already been cancelled.");
    }
}
// Koniec, Tydzień 6, Wzorzec State
