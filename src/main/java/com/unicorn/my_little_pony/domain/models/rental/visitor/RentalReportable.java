package com.unicorn.my_little_pony.domain.models.rental.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Interfejs elementu reprezentującego raport wypożyczenia

public interface RentalReportable {
    String accept(RentalVisitor visitor);
}
//Koniec tydzień 6, wzorzec visitor