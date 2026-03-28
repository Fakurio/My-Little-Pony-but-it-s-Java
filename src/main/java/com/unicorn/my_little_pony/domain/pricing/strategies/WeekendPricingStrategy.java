package com.unicorn.my_little_pony.domain.pricing.strategies;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 1
//Konkretna strategia implementująca dany algorytm obliczania ceny
public class WeekendPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(int hours, boolean isWeekend) {
        int baseRate = PricingConfig.getInstance().getBasePricePerHour();
        double total = baseRate * hours;

        if (isWeekend) {
            System.out.println("WeekendPricingStrategy: Doliczam +20% dopłaty weekendowej");
            total *= 1.20;
        }
        return total;
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy