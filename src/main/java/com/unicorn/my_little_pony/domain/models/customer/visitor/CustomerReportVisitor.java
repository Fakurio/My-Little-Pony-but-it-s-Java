package com.unicorn.my_little_pony.domain.models.customer.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 3
// Interfejs wizytatora raportów customers
public interface CustomerReportVisitor {
    String visit(CustomerUnicornReport report);
}
//Koniec tydzień 6, wzorzec visitor