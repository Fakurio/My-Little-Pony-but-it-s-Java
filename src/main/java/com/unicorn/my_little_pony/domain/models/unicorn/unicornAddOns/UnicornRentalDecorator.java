package com.unicorn.my_little_pony.domain.models.unicorn.unicornAddOns;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 1
// Abstrakcyjna klasa dekoratora - przechowuje referencję do komponentu i deleguje wywołania

public abstract class UnicornRentalDecorator implements UnicornRental {
    protected UnicornRental rental;

    public UnicornRentalDecorator(UnicornRental rental) {
        this.rental = rental;
    }

    @Override
    public double getPrice() {
        return rental.getPrice();
    }

    @Override
    public String getDescription() {
        return rental.getDescription();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 1
