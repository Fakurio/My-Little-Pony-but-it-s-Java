package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Konkretny stan zamówienia jednorożca
public class CancelledState implements OrderState {

    @Override
    public void submit(RentalOrder context) {
        System.out.println("Błąd: Nie można zatwierdzić anulowanego zamówienia.");
    }

    @Override
    public void pay(RentalOrder context) {
        System.out.println("Błąd: Zamówienie zostało anulowane, płatność jest zablokowana.");
    }

    @Override
    public void cancel(RentalOrder context) {
        System.out.println("Błąd: Zamówienie zostało już wcześniej anulowane.");
    }
}
// Koniec, Tydzień 6, Wzorzec State