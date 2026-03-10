package com.unicorn.my_little_pony.domain.models.unicorn.composite;

import java.util.ArrayList;
import java.util.List;

// Tydzień 3, Wzorzec Composite, Zastosowanie 2
// Klasa reprezentująca grupę jednorożców
public class Herd implements UnicornUnit {

    private final List<UnicornUnit> units = new ArrayList<>();

    public void add(UnicornUnit unit) {
        units.add(unit);
    }

    @Override
    public int getAvailableCount() {

        int total = 0;

        for (UnicornUnit unit : units) {
            total += unit.getAvailableCount();
        }

        return total;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 2