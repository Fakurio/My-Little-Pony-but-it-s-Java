package com.unicorn.my_little_pony.domain.models.support;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 3
// Konkretny dekorator - wsparcie 24/7 z opiekunem

public class TwentyFourHourCaretaker extends SupportDecorator {
    private static final double CARETAKER_COST = 80.0;

    public TwentyFourHourCaretaker(CustomerSupport support) {
        super(support);
    }

    @Override
    public double getCost() {
        return super.getCost() + CARETAKER_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " -> 24/7 support with caretaker";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 3
