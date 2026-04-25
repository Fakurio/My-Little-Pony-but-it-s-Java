package com.unicorn.my_little_pony.domain.models.rental.visitor;
// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Wizytator obliczający koszt wypożyczenia

public class RentalCostVisitor implements RentalVisitor {

    private static final int COST_PER_HOUR = 20;

    @Override
    public String visit(RentalReport r) {
        return "Cost: " + (r.getHours() * COST_PER_HOUR) + " PLN";
    }
}
// Koniec Tydzień 6, Wzorzec Visitor
