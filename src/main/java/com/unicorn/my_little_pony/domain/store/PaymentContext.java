package com.unicorn.my_little_pony.domain.store;

import com.unicorn.my_little_pony.domain.pricing.strategies.pricing.PricingStrategy;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 1
//Klasa kontekstu z metodą która wywołuje daną strategie cenową
public class PaymentContext {

    public double pay(PricingStrategy strategy, int hours, boolean isWeekend) {
        return strategy.calculatePrice(hours, isWeekend);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy
