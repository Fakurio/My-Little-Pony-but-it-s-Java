package com.unicorn.my_little_pony.domain.decorators.insurance;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 2
// Abstrakcyjna klasa dekoratora - przechowuje referencję do komponentu ubezpieczenia

public abstract class InsuranceDecorator implements RentalInsurance {
    protected RentalInsurance insurance;

    public InsuranceDecorator(RentalInsurance insurance) {
        this.insurance = insurance;
    }

    @Override
    public double getCost() {
        return insurance.getCost();
    }

    @Override
    public String getCoverage() {
        return insurance.getCoverage();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 2
