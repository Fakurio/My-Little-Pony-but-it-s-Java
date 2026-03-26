package com.unicorn.my_little_pony.domain.models.unicorn.interpreter;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 3
// Sprawdza kolor jednorożca
public class ColorExpression implements UnicornExpression {

    private String color;

    public ColorExpression(String color) {
        this.color = color;
    }

    @Override
    public boolean interpret(Unicorn unicorn) {
        return unicorn.getColor().equalsIgnoreCase(color);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 3