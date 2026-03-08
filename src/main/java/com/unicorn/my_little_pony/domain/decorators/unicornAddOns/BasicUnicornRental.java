package com.unicorn.my_little_pony.domain.decorators.unicornAddOns;

// Tydzień 4, Wzorzec Decorator, Zastosowanie 1
// Konkretny komponent - podstawowe wypożyczenie jednorożca bez żadnych dodatków

public class BasicUnicornRental implements UnicornRental {
    private final double basePrice;

    public BasicUnicornRental(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return "Basic unicorn rental";
    }
}
// Koniec, Tydzień 4, Wzorzec Decorator, Zastosowanie 1
