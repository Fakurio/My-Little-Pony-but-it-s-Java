package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

import com.unicorn.my_little_pony.domain.models.rentedUnicorn.RentedUnicorn;
import lombok.Getter;
import lombok.Setter;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Klasa kontekstu oddelegowuje zmiane stanu do obiektu danego stanu
public class RentedUnicornContext {
    @Setter
    private EnergyState state;
    @Getter
    private final RentedUnicorn unicorn;

    public RentedUnicornContext(RentedUnicorn unicorn) {
        this.unicorn = unicorn;
        this.state = new EnergeticState();
    }

    public void gallop() { state.gallop(this); }
    public void rest() { state.rest(this); }
}
// Koniec, Tydzień 6, Wzorzec State