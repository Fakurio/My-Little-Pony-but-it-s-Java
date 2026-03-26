package com.unicorn.my_little_pony.domain.models.rental.interpreter;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Sprawdza czy wypożyczenie jest aktywne
public class ActiveRentalExpression implements RentalExpression {

    @Override
    public boolean interpret(Rental rental) {
        return rental.getStatus() == RentalStatus.ACTIVE;
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3