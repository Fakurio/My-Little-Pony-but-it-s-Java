package com.unicorn.my_little_pony.domain.models.unicorn.builders;

import com.unicorn.my_little_pony.domain.models.unicorn.types.IceUnicorn;

// Tydzień 2, Wzorzec Builder, Zastosowanie 3
//Konkretna implementacja buildera dla IceUnicorn.

public class IceUnicornBuilder extends AbstractUnicornBuilder<IceUnicorn> {

    public IceUnicornBuilder() {
        this.powerLevel = 15;
    }

    @Override
    public IceUnicorn build() {
        IceUnicorn unicorn = new IceUnicorn(
                generateId(),
                name,
                color,
                powerLevel
        );

        unicorn.setStatus(status);
        return unicorn;
    }
}
// Koniec, Tydzień 2, Wzorzec Builder, Zastosowanie 3