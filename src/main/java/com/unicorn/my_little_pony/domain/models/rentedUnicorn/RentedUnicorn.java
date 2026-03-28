package com.unicorn.my_little_pony.domain.models.rentedUnicorn;

import com.unicorn.my_little_pony.domain.models.rentedUnicorn.states.EnergeticState;
import com.unicorn.my_little_pony.domain.models.rentedUnicorn.states.EnergyState;
import lombok.Getter;
import lombok.Setter;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Klasa kontekstu oddelegowuje zmiane stanu do obiektu danego stanu
@Setter
@Getter
public class RentedUnicorn {
    private EnergyState state;
    private int stamina = 100;

    public RentedUnicorn() { this.state = new EnergeticState(); }

    public void gallop() { state.gallop(this); }
    public void rest() { state.rest(this); }
}
// Koniec, Tydzień 6, Wzorzec State