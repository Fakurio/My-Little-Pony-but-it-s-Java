package com.unicorn.my_little_pony.domain.pricing.strategies.pricing;

import com.unicorn.my_little_pony.domain.pricing.PricingConfig;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 1
//Konkretna strategia implementująca dany algorytm obliczania ceny
public class StandardPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(int hours, boolean isWeekend) {
        int baseRate = PricingConfig.getInstance().getBasePricePerHour();
        System.out.println("StandardPricingStrategy: Stawka bazowa = " + baseRate + " PLN/h");
        return baseRate * hours;
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy