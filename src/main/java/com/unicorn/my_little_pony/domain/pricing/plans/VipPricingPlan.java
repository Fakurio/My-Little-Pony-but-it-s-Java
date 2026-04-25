package com.unicorn.my_little_pony.domain.pricing.plans;

import com.unicorn.my_little_pony.domain.pricing.engines.PricingEngine;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 1
// Konkretna implementacja planu cenowego, oddelegowuje obliczanie ceny do obiektu engine
// i nakłada ograniczenia na już obliczoną cene
public class VipPricingPlan extends PricingPlan {

    private static final double VIP_DISCOUNT_MULTIPLIER = 0.8;

    public VipPricingPlan(PricingEngine engine) {
        super(engine);
    }

    @Override
    public double calculateFinalPrice(int timeUnits) {
        double basePrice = engine.calculateBasePrice(timeUnits);
        return basePrice * VIP_DISCOUNT_MULTIPLIER;
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 1