package com.unicorn.my_little_pony.domain.models.rental.visitor;


// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Interfejs wizytatora raportów wydarzeń jednorożców
public interface EventReportVisitor {
    String visit(UnicornEventReport report);
}
//Koniec tydzień 6, wzorzec visitor
