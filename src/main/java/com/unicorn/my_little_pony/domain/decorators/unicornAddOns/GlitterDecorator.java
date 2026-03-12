package com.unicorn.my_little_pony.domain.decorators.unicornAddOns;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 1
// Konkretny dekorator - dodaje brokat do jednorożca

public class GlitterDecorator extends UnicornRentalDecorator {
    private static final double GLITTER_COST = 50.0;

    public GlitterDecorator(UnicornRental rental) {
        super(rental);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + GLITTER_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", glitter ✨";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 1
