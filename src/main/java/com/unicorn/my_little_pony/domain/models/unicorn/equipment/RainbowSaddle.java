package com.unicorn.my_little_pony.domain.models.unicorn.equipment;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 3
// Konkretna implementacja danego ekwipunku jednorożca
public class RainbowSaddle implements Equipment {

    @Override
    public String getDescription() {
        return "a comfortable Rainbow Saddle";
    }

    @Override
    public int getPowerBonus() {
        return 10;
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 3