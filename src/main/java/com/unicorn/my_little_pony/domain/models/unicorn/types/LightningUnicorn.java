package com.unicorn.my_little_pony.domain.models.unicorn.types;

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
}
// Koniec, Tydzień 2, Wzorzec Builder
