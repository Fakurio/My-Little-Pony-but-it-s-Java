package com.unicorn.my_little_pony.domain.models.rental.visitor;
// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Wizytator obliczający koszt wypożyczenia

public class RentalCostVisitor implements RentalVisitor {

    @Override
    public String visit(RentalReport r) {
        return "Cost: " + (r.getHours() * 20) + " PLN";
    }
}
// Koniec Tydzień 6, Wzorzec Visitor
