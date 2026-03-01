package com.unicorn.my_little_pony.domain.pricing.policies.cancellation;

// Tydzień 2, Wzorzec Abstract factory
// Konkretna implementacja polisy anulowania wypożyczenia
public class StrictCancellationPolicy implements CancellationPolicy {
    @Override
    public double getRefundPercentage() {
        return 0.0;
    }
}
// Koniec, Tydzień 2, Wzorzec Abstract factory