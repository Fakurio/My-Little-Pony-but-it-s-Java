package com.unicorn.my_little_pony.domain.models.unicorn.unicornAddOns;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 1
// Konkretny dekorator - dodaje polerowanie skrzydeł

public class WingPolishDecorator extends UnicornRentalDecorator {
    private static final double WING_POLISH_COST = 75.0;

    public WingPolishDecorator(UnicornRental rental) {
        super(rental);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + WING_POLISH_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", extra polished wings 🪽";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 1
