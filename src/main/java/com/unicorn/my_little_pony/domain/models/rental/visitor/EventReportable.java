package com.unicorn.my_little_pony.domain.models.rental.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Interfejs dla elementów raportu wydarzeń jednorożców
public interface EventReportable {
    String accept(EventReportVisitor visitor);
}
//Koniec tydzień 6, wzorzec visitor