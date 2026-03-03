package com.unicorn.my_little_pony.domain.models.unicorn.types;

import com.unicorn.my_little_pony.domain.models.unicorn.builders.IceUnicornBuilder;

// Tydzień 2, Wzorzec Builder
// Konkretna klasa jednorożca implementująca umiejętność specjalną
public class IceUnicorn extends Unicorn {

    public IceUnicorn(String id, String name, String color, int powerLevel) {
        super(id, name, color, powerLevel);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(getName() + " reezes water and creates an icy shield!");
    }

    //Tydzień 2, Wzorzec Prototype
    @Override
    public IceUnicorn clone() {
        return new IceUnicornBuilder()
                .name(this.getName())
                .color(this.getColor())
                .powerLevel(this.getPowerLevel())
                .status(this.getStatus())
                .build();
    }
    // Koniec, Tydzień 2, Wzorzec Prototype
}
// Koniec, Tydzień 2, Wzorzec Builder
