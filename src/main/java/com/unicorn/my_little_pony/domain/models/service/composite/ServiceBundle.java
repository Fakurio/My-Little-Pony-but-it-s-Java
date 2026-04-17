package com.unicorn.my_little_pony.domain.models.service.composite;

import java.util.ArrayList;
import java.util.List;

// Tydzień 3, Wzorzec Composite, Zastosowanie 1
// Klasa reprezentująca pakiet usług
//Tydzien 7, zasada pojedynczej odpowiedzialnosci, fukcja tworzaca opis zostala przeniesiona
//do osobnego pliku
public class ServiceBundle implements ServiceComponent {

    private final String name;
    private final List<ServiceComponent> items = new ArrayList<>();

    public ServiceBundle(String name) {
        this.name = name;
    }

    public void add(ServiceComponent component) {
        items.add(component);
    }

    public void remove(ServiceComponent component) {
        items.remove(component);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (ServiceComponent item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String getDescription() {
        return ServiceDescriptionBuilder.build(name, items);
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 1