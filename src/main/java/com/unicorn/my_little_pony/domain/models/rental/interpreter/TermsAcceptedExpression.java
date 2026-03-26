package com.unicorn.my_little_pony.domain.models.rental.interpreter;
import com.unicorn.my_little_pony.domain.models.rental.Rental;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Sprawdza czy klient zaakceptował regulamin

public class TermsAcceptedExpression implements RentalExpression {

    @Override
    public boolean interpret(Rental rental) {
        return rental.isTermsAccepted();
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3