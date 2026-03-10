package com.unicorn.my_little_pony.domain.models.unicorn.composite;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
// Tydzień 3, Wzorzec Composite, Zastosowanie 2
// Klasa reprezentująca pojedynczego jednorożca
public class SingleUnicorn implements UnicornUnit {

    private final Unicorn unicorn;

    public SingleUnicorn(Unicorn unicorn) {
        this.unicorn = unicorn;
    }

    @Override
    public int getAvailableCount() {

        if (unicorn.getStatus().name().equals("AVAILABLE")) {
            return 1;
        }

        return 0;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 2