package com.unicorn.my_little_pony.domain.pricing.policies.cancellation;

// Tydzień 2, Wzorzec Abstract factory
// Polisa anulowania wypożyczenia która będzie używana przy tworzeniu zestawu obiektów
// w fabryce planów cenowych
public interface CancellationPolicy {
    double getRefundPercentage();
}
// Koniec, Tydzień 2, Wzorzec Abstract factory