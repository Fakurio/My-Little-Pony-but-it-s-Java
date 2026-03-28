package com.unicorn.my_little_pony.domain.models.unicorn.states;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Interfejs z metodami przejścia pomiędzy stanami jednorożca
public interface UnicornState {
    void rent(Unicorn context);
    void returnUnicorn(Unicorn context);
    void clean(Unicorn context);
}
// Koniec, Tydzień 6, Wzorzec State