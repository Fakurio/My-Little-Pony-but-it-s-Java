package com.unicorn.my_little_pony.domain.models.unicorn.equipment;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 3
// Konkretna implementacja danego ekwipunku jednorożca
public class RainbowSaddle implements Equipment {
    private static final int RAINBOW_SADDLE_POWER_BONUS = 10;

    @Override
    public String getDescription() {
        return "a comfortable Rainbow Saddle";
    }

    @Override
    public int getPowerBonus() {
        return RAINBOW_SADDLE_POWER_BONUS;
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 3
