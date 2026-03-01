package com.unicorn.my_little_pony.domain.models.unicorn.factories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;

// Tydzień 2, Wzorzec Factory method
// Konkretna implementacja fabryki tworzącej dany typ jednorożca
public class WaterUnicornFactory extends UnicornFactory {

    @Override
    public Unicorn createUnicorn(String id, String name, String color) {
        return new WaterUnicorn(id, name, color, 10);
    }
}
// Koniec, Tydzień 2, Wzorzec Factory method