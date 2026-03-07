package com.unicorn.my_little_pony.domain.pricing.plans;

import com.unicorn.my_little_pony.domain.pricing.engines.PricingEngine;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 1
// Klasa bazowa dla wszystkich klas implementujących dany plan cenowy,
// jest to część abstrakcyjna wzorca bridge która oddelegowuje konkretny sposób obliczania ceny
// do obiektu engine
public abstract class PricingPlan {
    protected final PricingEngine engine;

    public PricingPlan(PricingEngine engine) {
        this.engine = engine;
    }

    public abstract double calculateFinalPrice(int timeUnits);
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 1