package com.unicorn.my_little_pony.domain.models.unicorn.types;

import com.unicorn.my_little_pony.domain.models.unicorn.equipment.Equipment;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.NoEquipment;
import com.unicorn.my_little_pony.domain.models.unicorn.states.AvailableState;
import com.unicorn.my_little_pony.domain.models.unicorn.states.UnicornState;
import com.unicorn.my_little_pony.enums.PowerLevelCategory;
import com.unicorn.my_little_pony.enums.UnicornStatus;
import lombok.Getter;
import lombok.Setter;

// Tydzień 2, Wzorzec Factory method, Zastosowanie 2
// Klasa abstrakcyjna która definiuje wspólny interfejs dla wszystkich
// jednorożców w systemie
// Tydzień 5, Wzorzec Iterator, Zastosowanie 1
// Klasa jednorożca która posiada status dostępności, który będzie wykorzystywany przez iterator do filtrowania jednorożców
// Tydzień 5, Wzorzec Iterator, Zastosowanie 3
// Klasa jednorożca która posiada powerLevel, który będzie wykorzystywany przez iterator do kategoryzowania jednorożców
@Getter
@Setter
public abstract class Unicorn implements Cloneable, IUnicorn {
    private static final int STRONG_POWER_THRESHOLD = 60;
    private static final int LEGENDARY_POWER_THRESHOLD = 100;

    private final String id;
    private final String name;
    private final String color;
    private final int powerLevel;
    private UnicornStatus status;
    private double price;
    private double rating;
    private UnicornState unicornState;
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

    public PowerLevelCategory getPowerLevelCategory() {
        int totalPower = getTotalPower();

        if (totalPower < STRONG_POWER_THRESHOLD) {
            return PowerLevelCategory.AVERAGE_PONY;
        } else if (totalPower < LEGENDARY_POWER_THRESHOLD) {
            return PowerLevelCategory.STRONG;
        } else {
            return PowerLevelCategory.LEGENDARY;
        }
    }

    @Override
    public String toString() {
        return "Unicorn{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", powerLevel=" + powerLevel +
                ", powerLevelCategory=" + getPowerLevelCategory() +
                ", status=" + status +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
    //Tydzień 2, Wzorzec Prototype, Zastosowanie 3
    // Metoda abstrakcyjna do klonowania obiektow
    public abstract Unicorn clone();
    // Koniec, Tydzień 2, Wzorzec Prototype, Zastosowanie 3

    //Tydzień 5, Wzorzec Memento, Zastosowanie 1
    // Klasa wew. i metody to zapisania i przywrócenia stanu ekwipunktu jednorożca
    public static class UnicornMemento {
        private final Equipment savedEquipment;

        public UnicornMemento(Equipment savedEquipment) {
            this.savedEquipment = savedEquipment;
        }
    }

    public UnicornMemento saveLoadout() {
        System.out.println("Saving current equipment: " + equipment.getDescription());
        return new UnicornMemento(this.equipment);
    }

    public void restoreLoadout(UnicornMemento memento) {
        this.equipment = memento.savedEquipment;
        System.out.println("Equipment restored: " + equipment.getDescription());
    }
    // Koniec, Tydzień 5, Wzorzec Memento
}
// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 3
// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 1
// Koniec, Tydzień 2, Wzorzec Factory method, Zastosowanie 2
