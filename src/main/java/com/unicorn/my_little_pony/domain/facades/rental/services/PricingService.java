package com.unicorn.my_little_pony.domain.facades.rental.services;

// Tydzień 4, Wzorzec Facade
// Serwis obliczający cenę wynajmu.

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

public class PricingService {

    public double calculatePrice(String unicornId) {

        PricingConfig config = PricingConfig.getInstance();

        double basePrice = config.getBasePricePerHour();

        if (unicornId.contains("RAINBOW")) {
            basePrice *= config.getRainbowPriceRaise();
        }

        System.out.println("Calculated price: " + basePrice);

        return basePrice;
    }
}
//Koniec Tydzień 4, Wzorzec Facade