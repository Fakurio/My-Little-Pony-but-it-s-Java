package com.unicorn.my_little_pony.domain.models.unicorn.builders;

import com.unicorn.my_little_pony.domain.models.unicorn.types.LightningUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;

// Tydzień 2, Wzorzec Builder, Zastosowanie 3
// Konkretna implementacja buildera dla LightningUnicorn.
public class LightningUnicornBuilder extends AbstractUnicornBuilder<LightningUnicorn> {
    private static final int DEFAULT_LIGHTNING_POWER_LEVEL = 35;

    public LightningUnicornBuilder() {
        this.powerLevel = DEFAULT_LIGHTNING_POWER_LEVEL;
    }

    @Override
    public LightningUnicorn build() {
        UnicornIdentity unicornIdentity = new UnicornIdentity(generateId(), name, color);
        LightningUnicorn unicorn = new LightningUnicorn(unicornIdentity, powerLevel);

        unicorn.setStatus(status);
        return unicorn;
    }
}
// Koniec, Tydzień 2, Wzorzec Builder, Zastosowanie 3
