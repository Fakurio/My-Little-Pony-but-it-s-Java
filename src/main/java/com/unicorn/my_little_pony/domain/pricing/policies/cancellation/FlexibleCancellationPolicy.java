package com.unicorn.my_little_pony.domain.pricing.policies.cancellation;

// Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
// Konkretna implementacja polisy anulowania wypożyczenia
public class FlexibleCancellationPolicy implements CancellationPolicy {
    private static final double FULL_REFUND_PERCENTAGE = 1.0;

    @Override
    public double getRefundPercentage() {
        return FULL_REFUND_PERCENTAGE;
    }
}
// Koniec, Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
