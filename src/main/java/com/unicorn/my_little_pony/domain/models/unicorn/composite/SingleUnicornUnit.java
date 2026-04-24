package com.unicorn.my_little_pony.domain.models.unicorn.composite;
//Tydzien 8, zasada Liskov
// Klasa reprezentująca pojedynczą jednostkę jednorożca.
// Implementuje interfejs UnicornUnit, dzięki czemu może być używana
// zamiennie wszędzie tam, gdzie oczekiwany jest typ UnicornUnit.
public class SingleUnicornUnit implements UnicornUnit {

    private final int count;

    public SingleUnicornUnit(int count) {
        this.count = count;
    }

    @Override
    public int getAvailableCount() {
        return count;
    }
}
//Koniec tydzien 8, zasada Liskov