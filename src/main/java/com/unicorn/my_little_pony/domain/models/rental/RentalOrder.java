package com.unicorn.my_little_pony.domain.models.rental;

import com.unicorn.my_little_pony.domain.models.rental.states.DraftState;
import com.unicorn.my_little_pony.domain.models.rental.states.OrderState;
import lombok.Setter;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Klasa kontekstu oddelegowuje zmiane stanu do obiektu danego stanu
@Setter
public class RentalOrder {
    private OrderState state;

    public RentalOrder() {
        this.state = new DraftState();
    }

    public void submit() { state.submit(this); }
    public void pay() { state.pay(this); }
    public void cancel() { state.cancel(this); }
}
// Koniec, Tydzień 6, Wzorzec State