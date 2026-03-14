package com.unicorn.my_little_pony.domain.models.insurance;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 2
// Konkretny dekorator - podstawowe ubezpieczenie

public class BasicInsurance extends InsuranceDecorator {
    private static final double BASIC_INSURANCE_COST = 30.0;

    public BasicInsurance(RentalInsurance insurance) {
        super(insurance);
    }

    @Override
    public double getCost() {
        return super.getCost() + BASIC_INSURANCE_COST;
    }

    @Override
    public String getCoverage() {
        String baseCoverage = super.getCoverage();
        if (baseCoverage.equals("No insurance")) {
            return "Basic insurance (OC)";
        }
        return baseCoverage + " -> Basic insurance (OC)";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 2
