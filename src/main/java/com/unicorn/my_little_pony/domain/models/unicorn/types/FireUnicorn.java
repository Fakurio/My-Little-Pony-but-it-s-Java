package com.unicorn.my_little_pony.domain.models.unicorn.types;

import com.unicorn.my_little_pony.domain.models.unicorn.factories.FireUnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.factories.UnicornFactory;
import com.unicorn.my_little_pony.util.IdGenerator;

// Tydzień 2, Wzorzec Factory method
// Konkretna klasa jednorożca implementująca umiejętność specjalną
public class FireUnicorn extends Unicorn {

    public FireUnicorn(String id, String name, String color, int powerLevel) {
        super(id, name, color, powerLevel);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(getName() + " breathes a stream of fire!");
    }

    //Tydzień 2, Wzorzec Prototype
    @Override
    public FireUnicorn clone() {
        UnicornFactory factory = new FireUnicornFactory();

        Unicorn cloned = factory.createUnicorn(
                IdGenerator.getInstance().nextUnicornId(),
                this.getName(),
                this.getColor()
        );

        cloned.setStatus(this.getStatus());
        return (FireUnicorn) cloned;
    }
    // Koniec, Tydzień 2, Wzorzec Prototype
}
// Koniec, Tydzień 2, Wzorzec Factory method
