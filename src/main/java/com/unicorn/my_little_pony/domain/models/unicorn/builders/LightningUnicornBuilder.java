package com.unicorn.my_little_pony.domain.models.unicorn.builders;

import com.unicorn.my_little_pony.domain.models.unicorn.types.LightningUnicorn;

// Tydzień 2, Wzorzec Builder, Zastosowanie 3
// Konkretna implementacja buildera dla LightningUnicorn.
public class LightningUnicornBuilder extends AbstractUnicornBuilder<LightningUnicorn> {

    public LightningUnicornBuilder() {
        this.powerLevel = 35;
    }

    @Override
    public LightningUnicorn build() {
        LightningUnicorn unicorn = new LightningUnicorn(
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