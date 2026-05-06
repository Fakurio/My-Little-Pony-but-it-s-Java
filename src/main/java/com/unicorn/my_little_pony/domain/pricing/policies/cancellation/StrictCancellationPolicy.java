package com.unicorn.my_little_pony.domain.pricing.policies.cancellation;

// Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
// Konkretna implementacja polisy anulowania wypożyczenia
public class StrictCancellationPolicy implements CancellationPolicy {
    private static final double NO_REFUND_PERCENTAGE = 0.0;

    @Override
    public double getRefundPercentage() {
        return NO_REFUND_PERCENTAGE;
    }
}
// Koniec, Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
