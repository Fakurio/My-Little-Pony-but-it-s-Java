package com.unicorn.my_little_pony.domain.pricing.plans;

import com.unicorn.my_little_pony.domain.pricing.engines.PricingEngine;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 1
// Konkretna implementacja planu cenowego, oddelegowuje obliczanie ceny do obiektu engine
// i nakłada ograniczenia na już obliczoną cene
public class StandardPricingPlan extends PricingPlan {

    public StandardPricingPlan(PricingEngine engine) {
        super(engine);
    }

    @Override
    public double calculateFinalPrice(int timeUnits) {
        return engine.calculateBasePrice(timeUnits);
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 1
