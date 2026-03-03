package com.unicorn.my_little_pony.domain.models.unicorn.types;

import com.unicorn.my_little_pony.domain.models.unicorn.factories.UnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.factories.WaterUnicornFactory;
import com.unicorn.my_little_pony.util.IdGenerator;

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

    //Tydzień 2, Wzorzec Prototype
    @Override
    public WaterUnicorn clone() {
        UnicornFactory factory = new WaterUnicornFactory();

        Unicorn cloned = factory.createUnicorn(
                IdGenerator.getInstance().nextUnicornId(),
                this.getName(),
                this.getColor()
        );

        cloned.setStatus(this.getStatus());
        return (WaterUnicorn) cloned;
    }
    // Koniec, Tydzień 2, Wzorzec Prototype
}
// Koniec, Tydzień 2, Wzorzec Factory method