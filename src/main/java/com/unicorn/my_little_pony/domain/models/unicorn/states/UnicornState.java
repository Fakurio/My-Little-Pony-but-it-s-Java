package com.unicorn.my_little_pony.domain.models.unicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 1
//Interfejs z metodami przejścia pomiędzy stanami jednorożca
public interface UnicornState {
    void rent(UnicornContext context);
    void returnUnicorn(UnicornContext context);
    void clean(UnicornContext context);
}
// Koniec, Tydzień 6, Wzorzec State