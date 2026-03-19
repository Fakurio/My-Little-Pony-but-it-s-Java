package com.unicorn.my_little_pony.domain.models.unicorn.unicornAddOns;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 1
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
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 1
