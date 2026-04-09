package com.unicorn.my_little_pony.domain.models.unicorn.states;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import lombok.Getter;
import lombok.Setter;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Klasa kontekstu oddelegowuje zmiane stanu do obiektu danego stanu
public class UnicornContext {
    @Setter
    private UnicornState state;
    @Getter
    private final Unicorn unicorn;

    public UnicornContext(Unicorn unicorn) {
        this.unicorn = unicorn;
        this.state = new AvailableState();
    }

    public void rent() { state.rent(this); }
    public void returnUnicorn() { state.returnUnicorn(this); }
    public void clean() { state.clean(this); }
}
// Koniec, Tydzień 6, Wzorzec State

