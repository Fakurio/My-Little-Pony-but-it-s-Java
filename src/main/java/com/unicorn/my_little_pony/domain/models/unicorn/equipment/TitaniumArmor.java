package com.unicorn.my_little_pony.domain.models.unicorn.equipment;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 3
// Konkretna implementacja danego ekwipunku jednorożca
public class TitaniumArmor implements Equipment {

    @Override
    public String getDescription() {
        return "heavy Titanium Battle Armor";
    }

    @Override
    public int getPowerBonus() {
        return 50;
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 3