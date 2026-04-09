package com.unicorn.my_little_pony.domain.models.unicorn.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 1
// Interfejs elementu, który akceptuje wizytatora
public interface UnicornElement {
    String accept(UnicornVisitor visitor);
}
//Koniec tydzień 6, wzorzec visitor