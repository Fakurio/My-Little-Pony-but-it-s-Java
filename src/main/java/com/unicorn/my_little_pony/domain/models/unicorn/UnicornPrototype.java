package com.unicorn.my_little_pony.domain.models.unicorn;

import com.unicorn.my_little_pony.domain.models.unicorn.types.*;

import java.util.ArrayList;
import java.util.List;

// Tydzień 2, Wzorzec Prototype
// Klasa implementuje interfejs Cloneable, co pozwala na tworzenie kopii istniejących obiektów.

public class UnicornPrototype implements Cloneable {

    private List<Unicorn> unicornTemplates;

    public UnicornPrototype() {
        this.unicornTemplates = new ArrayList<>();
    }

    public UnicornPrototype(List<Unicorn> list) {
        this.unicornTemplates = new ArrayList<>(list);
    }

    public void addTemplate(Unicorn unicorn) {
        unicornTemplates.add(unicorn);
    }

    public List<Unicorn> getUnicornTemplates() {
        return unicornTemplates;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<Unicorn> clonedList = new ArrayList<>();
        for (Unicorn u : unicornTemplates) {
            if (u instanceof FireUnicorn) {
                clonedList.add(new FireUnicorn(u.getId(), u.getName(), u.getColor(), u.getPowerLevel()));
            } else if (u instanceof WaterUnicorn) {
                clonedList.add(new WaterUnicorn(u.getId(), u.getName(), u.getColor(), u.getPowerLevel()));
            } else if (u instanceof LightningUnicorn) {
                clonedList.add(new LightningUnicorn(u.getId(), u.getName(), u.getColor(), u.getPowerLevel()));
            } else if (u instanceof IceUnicorn) {
                clonedList.add(new IceUnicorn(u.getId(), u.getName(), u.getColor(), u.getPowerLevel()));
            } else {
                throw new CloneNotSupportedException("Nieznany typ jednorożca: " + u.getClass());
            }
        }
        return new UnicornPrototype(clonedList);
    }
}
// Koniec, Tydzień 2, Wzorzec Prototype