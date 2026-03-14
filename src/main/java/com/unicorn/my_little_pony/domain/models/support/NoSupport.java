package com.unicorn.my_little_pony.domain.models.support;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 3
// Konkretny komponent - brak wsparcia technicznego (podstawa)

public class NoSupport implements CustomerSupport {

    @Override
    public double getCost() {
        return 0.0;
    }

    @Override
    public String getDescription() {
        return "No support";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 3
