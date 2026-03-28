package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Interfejs z metodami przejścia pomiędzy stanami zamówienia jednorożca
public interface OrderState {
    void submit(RentalOrder context);
    void pay(RentalOrder context);
    void cancel(RentalOrder context);
}
// Koniec, Tydzień 6, Wzorzec State