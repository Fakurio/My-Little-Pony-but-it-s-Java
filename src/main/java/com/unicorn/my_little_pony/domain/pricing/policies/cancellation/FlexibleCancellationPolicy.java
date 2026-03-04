package com.unicorn.my_little_pony.domain.pricing.policies.cancellation;

// Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
// Konkretna implementacja polisy anulowania wypożyczenia
public class FlexibleCancellationPolicy implements CancellationPolicy {

    @Override
    public double getRefundPercentage() {
        return 1.0;
    }
}
// Koniec, Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3