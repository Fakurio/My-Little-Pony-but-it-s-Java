package com.unicorn.my_little_pony.domain.facades.rental.services;

// Tydzień 4, Wzorzec Facade
// Serwis obliczający cenę wynajmu.

//Tydzien 7, zasada Open/Closed, abstrakcja
// Usunięte instrukcje warunkowe (if) zastąpione listą reguł (PricingRule).
// Dzięki temu nowe zasady cenowe mogą być dodawane poprzez nowe klasy,
// bez modyfikowania istniejącego kodu

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

import java.util.List;

public class PricingService {

    private final List<PricingRule> rules;

    public PricingService(List<PricingRule> rules) {
        this.rules = rules;
    }

    public double calculatePrice(String unicornId) {
        PricingConfig pricingConfig = PricingConfig.getInstance();
        double price = pricingConfig.getBasePricePerHour();

        for (PricingRule rule : rules) {
            if (rule.applies(unicornId)) {
                price = rule.apply(price, pricingConfig);
            }
        }

        return price;
    }
}
//Koniec Tydzień 4, Wzorzec Facade
