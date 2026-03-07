package com.unicorn.my_little_pony.domain.pricing.engines;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 1
// Konkretna implementacja sposobu naliczania ceny
public class HourlyPricingEngine implements PricingEngine {

    @Override
    public double calculateBasePrice(int hours) {
        return hours * PricingConfig.getInstance().getBasePricePerHour();
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 1