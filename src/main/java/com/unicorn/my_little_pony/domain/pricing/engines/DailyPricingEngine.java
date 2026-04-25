package com.unicorn.my_little_pony.domain.pricing.engines;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 1
// Konkretna implementacja sposobu naliczania ceny
public class DailyPricingEngine implements PricingEngine {

    private static final int HOURS_PER_DAY = 20;

    @Override
    public double calculateBasePrice(int days) {
        double dailyRate = PricingConfig.getInstance().getBasePricePerHour() * HOURS_PER_DAY;
        return dailyRate * days;
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 1
