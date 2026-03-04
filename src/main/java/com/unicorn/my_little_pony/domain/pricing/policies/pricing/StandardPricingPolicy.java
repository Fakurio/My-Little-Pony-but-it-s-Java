package com.unicorn.my_little_pony.domain.pricing.policies.pricing;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

// Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
// Konkretna implementacja polisy cennika wypożyczenia
public class StandardPricingPolicy implements PricingPolicy {

    @Override
    public double calculatePrice(int hours) {
        return hours * PricingConfig.getInstance().getBasePricePerHour();
    }
}
// Koniec, Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3