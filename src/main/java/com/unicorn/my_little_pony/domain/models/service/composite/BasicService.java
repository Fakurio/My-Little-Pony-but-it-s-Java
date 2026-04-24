package com.unicorn.my_little_pony.domain.models.service.composite;
//Tydzien 8, zasada Liskov
// Klasa reprezentująca pojedynczą usługę (element prosty w Composite).
// Implementuje interfejs ServiceComponent i może być używana zamiennie
// z innymi implementacjami tego interfejsu, np. ServiceBundle.

public class BasicService implements ServiceComponent {

    private final String name;
    private final double price;

    public BasicService(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return name;
    }
}
// Koniec tygodnia 8 zasady Liskov