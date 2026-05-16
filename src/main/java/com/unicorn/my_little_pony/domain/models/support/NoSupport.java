package com.unicorn.my_little_pony.domain.models.support;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 3
// Konkretny komponent - brak wsparcia technicznego (podstawa)

public class NoSupport implements CustomerSupport {
    private static final double NO_SUPPORT_COST = 0.0;

    @Override
    public double getCost() {
        return NO_SUPPORT_COST;
    }

    @Override
    public String getDescription() {
        return "No support";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 3
