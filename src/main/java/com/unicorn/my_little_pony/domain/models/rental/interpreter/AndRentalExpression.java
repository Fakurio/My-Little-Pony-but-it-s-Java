package com.unicorn.my_little_pony.domain.models.rental.interpreter;
import com.unicorn.my_little_pony.domain.models.rental.Rental;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Łączy dwa warunki logiczne AND


public class AndRentalExpression implements RentalExpression {

    private RentalExpression left;
    private RentalExpression right;

    public AndRentalExpression(RentalExpression left, RentalExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Rental rental) {
        return left.interpret(rental) && right.interpret(rental);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3