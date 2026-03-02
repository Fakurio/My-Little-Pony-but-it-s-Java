package com.unicorn.my_little_pony.domain.models.unicorn.builders;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;
import com.unicorn.my_little_pony.util.IdGenerator;

// Tydzień 2, Wzorzec Builder
//Abstrakcyjna klasa buildera dla jednorożców. Definiuje wspólne pola i metody dla wszystkich konkretnych builderów
// W odróżnieniu od Factory, Builder umożliwia większą kontrolę nad wszystkimi polami obiektu.

public abstract class AbstractUnicornBuilder<T extends Unicorn> {

    protected String name;
    protected String color;
    protected int powerLevel;
    protected UnicornStatus status = UnicornStatus.AVAILABLE;

    public AbstractUnicornBuilder<T> name(String name) {
        this.name = name;
        return this;
    }

    public AbstractUnicornBuilder<T> color(String color) {
        this.color = color;
        return this;
    }

    public AbstractUnicornBuilder<T> powerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
        return this;
    }

    public AbstractUnicornBuilder<T> status(UnicornStatus status) {
        this.status = status;
        return this;
    }

    protected String generateId() {
        return IdGenerator.getInstance().nextUnicornId();
    }

    public abstract T build();
}
// Koniec, Tydzień 2, Wzorzec Builder