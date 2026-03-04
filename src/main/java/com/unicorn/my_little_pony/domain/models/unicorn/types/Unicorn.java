package com.unicorn.my_little_pony.domain.models.unicorn.types;

import com.unicorn.my_little_pony.enums.UnicornStatus;
import lombok.Getter;
import lombok.Setter;

// Tydzień 2, Wzorzec Factory method, Zastosowanie 2
// Klasa abstrakcyjna która definiuje wspólny interfejs dla wszystkich
// jednorożców w systemie
@Getter
@Setter
public abstract class Unicorn implements Cloneable{
    private final String id;
    private final String name;
    private final String color;
    private final int powerLevel;
    private UnicornStatus status;

    public Unicorn(String id, String name, String color, int powerLevel) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.powerLevel = powerLevel;
        this.status = UnicornStatus.AVAILABLE;
    }

    public abstract void useSpecialAbility();

    @Override
    public String toString() {
        return "Unicorn{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", powerLevel=" + powerLevel +
                ", status=" + status +
                '}';
    }
    //Tydzień 2, Wzorzec Prototype, Zastosowanie 3
    // Metoda abstrakcyjna do klonowania obiektow
    public abstract Unicorn clone();
    // Koniec, Tydzień 2, Wzorzec Prototype, Zastosowanie 3
}
// Koniec, Tydzień 2, Wzorzec Factory method, Zastosowanie 2
