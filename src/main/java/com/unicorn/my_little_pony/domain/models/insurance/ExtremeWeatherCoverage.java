package com.unicorn.my_little_pony.domain.models.insurance;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 2
// Konkretny dekorator - ubezpieczenie od ekstremalnych warunków pogodowych

public class ExtremeWeatherCoverage extends InsuranceDecorator {
    private static final double WEATHER_COVERAGE_COST = 45.0;

    public ExtremeWeatherCoverage(RentalInsurance insurance) {
        super(insurance);
    }

    @Override
    public double getCost() {
        return super.getCost() + WEATHER_COVERAGE_COST;
    }

    @Override
    public String getCoverage() {
        return super.getCoverage() + " -> Extreme weather coverage (storms, heatvave, etc.)";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 2
