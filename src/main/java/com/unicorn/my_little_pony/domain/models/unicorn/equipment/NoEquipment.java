package com.unicorn.my_little_pony.domain.models.unicorn.equipment;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 3
// Konkretna implementacja danego ekwipunku jednorożca. Ten przypadek służy za placeholder
// kiedy jednorożec nie ma ekwipunku
public class NoEquipment implements Equipment {
    private static final int NO_POWER_BONUS = 0;

    @Override
    public String getDescription() {
        return "this unicorn doesn't have equipment yet";
    }

    @Override
    public int getPowerBonus() {
        return NO_POWER_BONUS;
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 3
