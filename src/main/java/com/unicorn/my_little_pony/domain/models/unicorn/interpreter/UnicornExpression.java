package com.unicorn.my_little_pony.domain.models.unicorn.interpreter;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Interfejs do interpretowania warunków filtrowania jednorożców
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

public interface UnicornExpression {
    boolean interpret(Unicorn unicorn);
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3