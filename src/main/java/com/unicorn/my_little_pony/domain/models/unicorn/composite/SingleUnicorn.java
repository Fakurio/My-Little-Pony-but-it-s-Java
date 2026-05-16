package com.unicorn.my_little_pony.domain.models.unicorn.composite;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;
// Tydzień 3, Wzorzec Composite, Zastosowanie 2
// Klasa reprezentująca pojedynczego jednorożca
public class SingleUnicorn implements UnicornUnit {
    private static final int AVAILABLE_UNICORN_COUNT = 1;
    private static final int UNAVAILABLE_UNICORN_COUNT = 0;

    private final Unicorn unicorn;

    public SingleUnicorn(Unicorn unicorn) {
        this.unicorn = unicorn;
    }

    @Override
    public int getAvailableCount() {
        if (unicorn.getStatus() == UnicornStatus.AVAILABLE) {
            return AVAILABLE_UNICORN_COUNT;
        }
        return UNAVAILABLE_UNICORN_COUNT;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 2
