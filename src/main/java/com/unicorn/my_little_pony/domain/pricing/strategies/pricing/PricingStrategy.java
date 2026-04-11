package com.unicorn.my_little_pony.domain.pricing.strategies.pricing;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 1
//Interfejs dla konkretnych algorytmów obliczania ceny
public interface PricingStrategy {
    double calculatePrice(int hours, boolean isWeekend);
}
// Koniec, Tydzień 6, Wzorzec Strategy