package com.unicorn.my_little_pony.domain.models.unicorn.types;

// Tydzień 2, Wzorzec Factory method
// Konkretna klasa jednorożca implementująca umiejętność specjalną
public class WaterUnicorn extends Unicorn {

    public WaterUnicorn(String id, String name, String color, int powerLevel) {
        super(id, name, color, powerLevel);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(getName() + " can walk on water!");
    }
}
// Koniec, Tydzień 2, Wzorzec Factory method