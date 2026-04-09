package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;
import lombok.Setter;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Klasa kontekstu oddelegowuje zmiane stanu do obiektu danego stanu
@Setter
public class RentalOrderContext {
    private OrderState state;
    private RentalOrder rentalOrder;

    public RentalOrderContext(RentalOrder order) {
        this.state = new DraftState();
        this.rentalOrder = order;
    }

    public void submit() { state.submit(this); }
    public void pay() { state.pay(this); }
    public void cancel() { state.cancel(this); }
}
// Koniec, Tydzień 6, Wzorzec State