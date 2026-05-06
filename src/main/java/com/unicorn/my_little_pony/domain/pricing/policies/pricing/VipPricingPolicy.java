package com.unicorn.my_little_pony.domain.pricing.policies.pricing;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

// Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
// Konkretna implementacja polisy cennika wypożyczenia
public class VipPricingPolicy implements PricingPolicy {
    private static final double VIP_DISCOUNT_MULTIPLIER = 0.8;

    @Override
    public double calculatePrice(int hours) {
        return hours * (PricingConfig.getInstance().getBasePricePerHour() * VIP_DISCOUNT_MULTIPLIER);
    }
}
// Koniec, Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
