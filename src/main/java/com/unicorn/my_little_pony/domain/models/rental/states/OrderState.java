package com.unicorn.my_little_pony.domain.models.rental.states;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Interfejs z metodami przejścia pomiędzy stanami zamówienia jednorożca
public interface OrderState {
    void submit(RentalOrderContext context);
    void pay(RentalOrderContext context);
    void cancel(RentalOrderContext context);
}
// Koniec, Tydzień 6, Wzorzec State