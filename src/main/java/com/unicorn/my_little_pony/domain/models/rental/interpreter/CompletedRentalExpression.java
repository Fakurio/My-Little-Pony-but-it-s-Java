package com.unicorn.my_little_pony.domain.models.rental.interpreter;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Sprawdza czy wypożyczenie zostało zakończone
public class CompletedRentalExpression implements RentalExpression {

    @Override
    public boolean interpret(Rental rental) {
        return rental.getStatus() == RentalStatus.COMPLETED;
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3