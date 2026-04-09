package com.unicorn.my_little_pony.domain.models.customer.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 3
// Interfejs dla elementów raportu customers, które mogą być odwiedzane
public interface CustomerReportable {
    String accept(CustomerReportVisitor visitor);
}
//Koniec tydzień 6, wzorzec visitor