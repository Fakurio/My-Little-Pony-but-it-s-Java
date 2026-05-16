package com.unicorn.my_little_pony.domain.models.unicorn.factories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;

// Tydzień 2, Wzorzec Factory method, Zastosowanie 2
// Konkretna implementacja fabryki tworzącej dany typ jednorożca
public class WaterUnicornFactory extends UnicornFactory {
    private static final int DEFAULT_WATER_POWER_LEVEL = 10;

    @Override
    public Unicorn createUnicorn(String id, String name, String color) {
        UnicornIdentity unicornIdentity = new UnicornIdentity(id, name, color);
        return new WaterUnicorn(unicornIdentity, DEFAULT_WATER_POWER_LEVEL);
    }
}
// Koniec, Tydzień 2, Wzorzec Factory method, Zastosowanie 2
