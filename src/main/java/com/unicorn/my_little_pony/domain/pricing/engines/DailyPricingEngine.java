package com.unicorn.my_little_pony.domain.pricing.engines;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 1
// Konkretna implementacja sposobu naliczania ceny
public class DailyPricingEngine implements PricingEngine {

    @Override
    public double calculateBasePrice(int days) {
        double dailyRate = PricingConfig.getInstance().getBasePricePerHour() * 20;
        return dailyRate * days;
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 1
