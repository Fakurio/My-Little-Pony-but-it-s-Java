package com.unicorn.my_little_pony.domain.decorators.unicornAddOns;

// Tydzień 4, Wzorzec Decorator, Zastosowanie 1
// Konkretny dekorator - dodaje tęczową grzywę

public class RainbowManeDecorator extends UnicornRentalDecorator {
    private static final double RAINBOW_MANE_COST = 100.0;

    public RainbowManeDecorator(UnicornRental rental) {
        super(rental);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + RAINBOW_MANE_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", rainbow mane 🌈";
    }
}
// Koniec, Tydzień 4, Wzorzec Decorator, Zastosowanie 1
