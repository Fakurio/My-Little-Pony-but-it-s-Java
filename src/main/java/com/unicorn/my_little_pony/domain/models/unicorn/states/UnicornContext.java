package com.unicorn.my_little_pony.domain.models.unicorn.states;

import com.unicorn.my_little_pony.aspect.audit.Auditable;
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

    // Tydzień 11, Programowanie Aspektowe, Zastosowanie 3
    // Metody które mają być audytowane są oznaczone adnotacją @Auditable
    @Auditable
    public void rent() { state.rent(this); }
    @Auditable
    public void returnUnicorn() { state.returnUnicorn(this); }
    @Auditable
    public void clean() { state.clean(this); }
    // Koniec, Tydzień 11, Programowanie Aspektowe, Zastosowanie 3    
}
// Koniec, Tydzień 6, Wzorzec State

