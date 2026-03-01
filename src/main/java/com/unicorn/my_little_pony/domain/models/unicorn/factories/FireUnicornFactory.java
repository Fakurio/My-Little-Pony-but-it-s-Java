package com.unicorn.my_little_pony.domain.models.unicorn.factories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 2, Wzorzec Factory method
// Konkretna implementacja fabryki tworzącej dany typ jednorożca
public class FireUnicornFactory extends UnicornFactory {

    @Override
    public Unicorn createUnicorn(String id, String name, String color) {
        return new FireUnicorn(id, name, color, 20);
    }
}
// Koniec, Tydzień 2, Wzorzec Factory method
