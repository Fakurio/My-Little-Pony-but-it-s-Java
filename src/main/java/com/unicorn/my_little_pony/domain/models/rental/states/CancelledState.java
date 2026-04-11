package com.unicorn.my_little_pony.domain.models.rental.states;

import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;

//Tydzień 6, Wzorzec State, Zastosowanie 2
//Konkretny stan zamówienia jednorożca
public class CancelledState implements OrderState {

    @Override
    public void submit(RentalOrderContext context) {
        System.out.println("Błąd: Nie można zatwierdzić anulowanego zamówienia.");
    }

    @Override
    public void pay(RentalOrderContext context) {
        System.out.println("Błąd: Zamówienie zostało anulowane, płatność jest zablokowana.");
    }

    @Override
    public void cancel(RentalOrderContext context) {
        System.out.println("Błąd: Zamówienie zostało już wcześniej anulowane.");
    }
}
// Koniec, Tydzień 6, Wzorzec State