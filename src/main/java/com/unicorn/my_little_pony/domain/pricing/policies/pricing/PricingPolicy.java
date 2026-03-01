package com.unicorn.my_little_pony.domain.pricing.policies.pricing;

// Tydzień 2, Wzorzec Abstract factory
// Polisa cennika wypożyczenia która będzie używana przy tworzeniu zestawu obiektów
// w fabryce planów cenowych
public interface PricingPolicy {
    double calculatePrice(int hours);
}
// Koniec, Tydzień 2, Wzorzec Abstract factory
