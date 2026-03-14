package com.unicorn.my_little_pony.domain.models.insurance;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 2
// Konkretny komponent - brak ubezpieczenia (podstawa)

public class NoInsurance implements RentalInsurance {

    @Override
    public double getCost() {
        return 0.0;
    }

    @Override
    public String getCoverage() {
        return "No insurance coverage";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 2
