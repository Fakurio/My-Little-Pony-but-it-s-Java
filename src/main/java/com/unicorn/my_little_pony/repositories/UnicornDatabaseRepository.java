package com.unicorn.my_little_pony.repositories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;
import com.unicorn.my_little_pony.util.IdGenerator;

import java.util.List;

//Tydzień 8, DI, Zastosowanie 2
//Implementacja modułu niskopoziomowego zgodna z wymaganiami modułu wysokopoziomowego
public class UnicornDatabaseRepository implements UnicornRepository{
    private static final int BLAZE_POWER_LEVEL = 100;
    private static final int SPARKLE_POWER_LEVEL = 120;

    private final List<Unicorn> unicorns = List.of(
            new FireUnicorn(
                    new UnicornIdentity(IdGenerator.getInstance().nextUnicornId(), "Blaze", "red"),
                    BLAZE_POWER_LEVEL
            ),
            new WaterUnicorn(
                    new UnicornIdentity(IdGenerator.getInstance().nextUnicornId(), "Sparkle", "blue"),
                    SPARKLE_POWER_LEVEL
            )
    );

    @Override
    public List<Unicorn> getAllUnicorns() {
        return this.unicorns;
    }
}
//Koniec, Tydzień 8, DI
