package com.unicorn.my_little_pony.domain.models.unicorn.visitor;


import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 1
// Interfejs wizytatora dla raportów magicznych
public interface UnicornVisitor {
    String visit(FireUnicorn unicorn);
    String visit(WaterUnicorn unicorn);
}
//Koniec tydzień 6, wzorzec visitor