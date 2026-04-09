package com.unicorn.my_little_pony.domain.models.unicorn.types;

import com.unicorn.my_little_pony.domain.models.unicorn.factories.UnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.factories.WaterUnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.visitor.UnicornElement;
import com.unicorn.my_little_pony.domain.models.unicorn.visitor.UnicornVisitor;
import com.unicorn.my_little_pony.util.IdGenerator;

// Tydzień 2, Wzorzec Factory method, Zastosowanie 2
// Konkretna klasa jednorożca implementująca umiejętność specjalną
public class WaterUnicorn extends Unicorn implements UnicornElement {

    public WaterUnicorn(String id, String name, String color, int powerLevel) {
        super(id, name, color, powerLevel);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(getName() + " can walk on water!");
    }

    //Tydzień 2, Wzorzec Prototype, Zastosowanie 3
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
    //Tydzien 6, wzorzec visitor
    @Override
    public String accept(UnicornVisitor visitor) {
        return visitor.visit(this);
    }
    //Koniec, tydzien 6 wzorzec visitor
    // Koniec, Tydzień 2, Wzorzec Prototype, Zastosowanie 3
}
// Koniec, Tydzień 2, Wzorzec Factory method, Zastosowanie 2