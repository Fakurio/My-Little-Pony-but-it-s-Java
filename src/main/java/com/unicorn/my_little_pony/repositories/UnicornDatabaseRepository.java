package com.unicorn.my_little_pony.repositories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;
import com.unicorn.my_little_pony.util.IdGenerator;

import java.util.List;

//Tydzień 8, DI, Zastosowanie 2
//Implementacja modułu niskopoziomowego zgodna z wymaganiami modułu wysokopoziomowego
public class UnicornDatabaseRepository implements UnicornRepository{
    private final List<Unicorn> unicorns = List.of(
            new FireUnicorn(IdGenerator.getInstance().nextUnicornId(), "Blaze", "red", 100),
            new WaterUnicorn(IdGenerator.getInstance().nextUnicornId(), "Sparkle", "blue", 120)
    );

    @Override
    public List<Unicorn> getAllUnicorn() {
        return this.unicorns;
    }
}
//Koniec, Tydzień 8, DI