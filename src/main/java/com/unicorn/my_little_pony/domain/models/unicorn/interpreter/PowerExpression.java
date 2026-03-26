package com.unicorn.my_little_pony.domain.models.unicorn.interpreter;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Sprawdza poziom mocy jednorożca
public class PowerExpression implements UnicornExpression {

    private int minPower;

    public PowerExpression(int minPower) {
        this.minPower = minPower;
    }

    @Override
    public boolean interpret(Unicorn unicorn) {
        return unicorn.getPowerLevel() > minPower;
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3