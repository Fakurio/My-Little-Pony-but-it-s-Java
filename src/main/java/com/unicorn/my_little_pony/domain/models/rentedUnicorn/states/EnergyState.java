package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

import com.unicorn.my_little_pony.domain.models.rentedUnicorn.RentedUnicorn;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Interfejs z metodami przejścia pomiędzy stanami energi wypożyczonego jednorożca
public interface EnergyState {
    void gallop(RentedUnicorn context);
    void rest(RentedUnicorn context);
}
// Koniec, Tydzień 6, Wzorzec State