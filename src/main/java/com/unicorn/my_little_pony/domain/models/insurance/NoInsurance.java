package com.unicorn.my_little_pony.domain.models.insurance;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 2
// Konkretny komponent - brak ubezpieczenia (podstawa)

public class NoInsurance implements RentalInsurance {
    private static final double NO_INSURANCE_COST = 0.0;

    @Override
    public double getCost() {
        return NO_INSURANCE_COST;
    }

    @Override
    public String getCoverage() {
        return "No insurance coverage";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 2
