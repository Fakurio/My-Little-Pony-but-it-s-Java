package com.unicorn.my_little_pony.domain.decorators.insurance;

// Tydzień 4, Wzorzec Decorator, Zastosowanie 2
// Konkretny dekorator - rozszerzone ubezpieczenie

public class ExtendedInsurance extends InsuranceDecorator {
    private static final double EXTENDED_INSURANCE_COST = 60.0;

    public ExtendedInsurance(RentalInsurance insurance) {
        super(insurance);
    }

    @Override
    public double getCost() {
        return super.getCost() + EXTENDED_INSURANCE_COST;
    }

    @Override
    public String getCoverage() {
        return super.getCoverage() + " -> Extended insurance (UC {Unicorn Casco} + liability + theft)";
    }
}
// Koniec, Tydzień 4, Wzorzec Decorator, Zastosowanie 2
