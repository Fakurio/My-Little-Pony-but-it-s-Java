package com.unicorn.my_little_pony.domain.models.unicorn.interpreter;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Łączy dwa warunki AND
public class AndExpression implements UnicornExpression {

    private UnicornExpression left;
    private UnicornExpression right;

    public AndExpression(UnicornExpression left, UnicornExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Unicorn unicorn) {
        return left.interpret(unicorn) && right.interpret(unicorn);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3