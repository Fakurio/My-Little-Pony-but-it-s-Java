package com.unicorn.my_little_pony.domain.models.rental.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Wizytator generujący opis tekstowy wypożyczenia

public class RentalTextVisitor implements RentalVisitor {

    @Override
    public String visit(RentalReport r) {
        return r.getUnicornName() + " rented for " + r.getHours() + " hours";
    }
}
//Koniec tydzień 6, wzorzec visitor