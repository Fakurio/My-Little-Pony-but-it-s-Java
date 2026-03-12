package com.unicorn.my_little_pony.domain.models.unicorn.types;

import com.unicorn.my_little_pony.domain.models.unicorn.equipment.Equipment;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.NoEquipment;
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
    // Tydzień 3, Wzorzec Bridge, Zastosowanie 3
    // Część abstrakcyjna wzorca bridge która oddelegowuje użycie konkretnego ekwipunku do obiektu equipment
    private Equipment equipment;
    // Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 3

    public Unicorn(String id, String name, String color, int powerLevel) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.powerLevel = powerLevel;
        this.status = UnicornStatus.AVAILABLE;
        this.equipment = new NoEquipment();
    }

    public abstract void useSpecialAbility();

    // Tydzień 3, Wzorzec Bridge, Zastosowanie 3
    // Wspólna logika obliczania powerLevel dla jednorożców z oddelegowaniem logiki obliczania bonusu ekwipunku
    // do konkretnego obiektu ekwipunku
    public int getTotalPower() {
        return powerLevel + equipment.getPowerBonus();
    }
    // Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 3

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
