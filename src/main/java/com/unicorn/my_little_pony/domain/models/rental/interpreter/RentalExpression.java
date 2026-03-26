package com.unicorn.my_little_pony.domain.models.rental.interpreter;
import com.unicorn.my_little_pony.domain.models.rental.Rental;
// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Interfejs interpretujący warunki dotyczące wypożyczenia

public interface RentalExpression {
    boolean interpret(Rental rental);
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3