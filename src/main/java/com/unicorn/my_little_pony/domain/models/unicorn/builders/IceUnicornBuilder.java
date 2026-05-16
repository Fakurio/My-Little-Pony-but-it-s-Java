package com.unicorn.my_little_pony.domain.models.unicorn.builders;

import com.unicorn.my_little_pony.domain.models.unicorn.types.IceUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;

// Tydzień 2, Wzorzec Builder, Zastosowanie 3
//Konkretna implementacja buildera dla IceUnicorn.

public class IceUnicornBuilder extends AbstractUnicornBuilder<IceUnicorn> {
    private static final int DEFAULT_ICE_POWER_LEVEL = 15;

    public IceUnicornBuilder() {
        this.powerLevel = DEFAULT_ICE_POWER_LEVEL;
    }

    @Override
    public IceUnicorn build() {
        UnicornIdentity unicornIdentity = new UnicornIdentity(generateId(), name, color);
        IceUnicorn unicorn = new IceUnicorn(unicornIdentity, powerLevel);

        unicorn.setStatus(status);
        return unicorn;
    }
}
// Koniec, Tydzień 2, Wzorzec Builder, Zastosowanie 3
