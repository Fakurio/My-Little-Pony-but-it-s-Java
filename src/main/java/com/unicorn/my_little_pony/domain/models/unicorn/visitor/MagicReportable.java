package com.unicorn.my_little_pony.domain.models.unicorn.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 1
// Interfejs dla elementów raportu magicznego, które mogą być odwiedzane
public interface MagicReportable {
    String accept(MagicReportVisitor visitor);
}
//Koniec tydzień 6, wzorzec visitor