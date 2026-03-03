package com.unicorn.my_little_pony.domain.models.unicorn.types;

import com.unicorn.my_little_pony.domain.models.unicorn.builders.LightningUnicornBuilder;

// Tydzień 2, Wzorzec Builder
// Konkretna klasa jednorożca implementująca umiejętność specjalną
public class LightningUnicorn extends Unicorn {

    public LightningUnicorn(String id, String name, String color, int powerLevel) {
        super(id, name, color, powerLevel);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(getName() + " summons lightning and runs at super speed!");
    }

    //Tydzień 2, Wzorzec Prototype
    @Override
    public LightningUnicorn clone() {
        return new LightningUnicornBuilder()
                .name(this.getName())
                .color(this.getColor())
                .powerLevel(this.getPowerLevel())
                .status(this.getStatus())
                .build();
    }
    // Koniec, Tydzień 2, Wzorzec Prototype
}
// Koniec, Tydzień 2, Wzorzec Builder
