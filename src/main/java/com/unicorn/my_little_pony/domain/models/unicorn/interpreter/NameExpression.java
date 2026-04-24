package com.unicorn.my_little_pony.domain.models.unicorn.interpreter;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzien 8, zasada Liskov
// Nowa implementacja UnicornExpression sprawdzająca nazwę jednorożca
// Może być używana zamiennie z innymi wyrażeniami (ColorExpression, PowerExpression)

public class NameExpression implements UnicornExpression {

    private String name;

    public NameExpression(String name) {
        this.name = name;
    }

    @Override
    public boolean interpret(Unicorn unicorn) {
        return unicorn.getName().equalsIgnoreCase(name);
    }
}
//Koniec tydzien 8, zasada Liskov