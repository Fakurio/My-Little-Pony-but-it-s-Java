package com.unicorn.my_little_pony.domain.facades.rental.services;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;
//Tydzien 7, zasada open/closed, abstrakcja
// Interfejs reprezentujący regułę cenową.
public interface PricingRule {
    boolean applies(String unicornId);
    double apply(double basePrice, PricingConfig config);
}
