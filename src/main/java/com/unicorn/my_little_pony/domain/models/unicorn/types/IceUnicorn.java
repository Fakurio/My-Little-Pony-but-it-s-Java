package com.unicorn.my_little_pony.domain.models.unicorn.types;

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
}
// Koniec, Tydzień 2, Wzorzec Builder
