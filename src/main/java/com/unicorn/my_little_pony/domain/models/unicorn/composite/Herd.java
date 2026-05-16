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

    //Tydzień 10, Użycie interfejsu funkcyjnego do wykonywania akcji na jednostce
    public void forEachUnit(UnitAction action) {
        for (UnicornUnit unit : units) {
            action.perform(unit);
        }
    }
    //Koniec, Tydzień 10
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 2