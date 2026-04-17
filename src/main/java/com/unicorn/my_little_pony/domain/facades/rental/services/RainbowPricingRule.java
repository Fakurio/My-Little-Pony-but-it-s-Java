package com.unicorn.my_little_pony.domain.facades.rental.services;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;
//Tydzien 7, zasada open/closed, abstrakcja
// Implementacja reguły cenowej dla jednorożców typu RAINBOW.

public class RainbowPricingRule implements PricingRule {

    @Override
    public boolean applies(String unicornId) {
        return unicornId.contains("RAINBOW");
    }

    @Override
    public double apply(double basePrice, PricingConfig config) {
        return basePrice * config.getRainbowPriceRaise();
    }
}