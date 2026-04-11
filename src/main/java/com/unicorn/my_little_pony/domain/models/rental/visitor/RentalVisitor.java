package com.unicorn.my_little_pony.domain.models.rental.visitor;


// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Interfejs wizytatora dla operacji na wypożyczeniach

public interface RentalVisitor {
    String visit(RentalReport report);
}
//Koniec tydzień 6, wzorzec visitor
