package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Interfejs z metodami przejścia pomiędzy stanami energi wypożyczonego jednorożca
public interface EnergyState {
    void gallop(RentedUnicornContext context);
    void rest(RentedUnicornContext context);
}
// Koniec, Tydzień 6, Wzorzec State