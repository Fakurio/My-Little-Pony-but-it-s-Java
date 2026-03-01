package com.unicorn.my_little_pony.domain.pricing.policies;

import com.unicorn.my_little_pony.domain.pricing.policies.cancellation.CancellationPolicy;
import com.unicorn.my_little_pony.domain.pricing.policies.cancellation.StrictCancellationPolicy;
import com.unicorn.my_little_pony.domain.pricing.policies.pricing.PricingPolicy;
import com.unicorn.my_little_pony.domain.pricing.policies.pricing.StandardPricingPolicy;

// Tydzień 2, Wzorzec Abstract factory
// Konkretna implementacja danego planu cenowego
public class StandardPricingFactory implements PricingFactory {

    @Override
    public PricingPolicy creaetPricingPolicy() {
        return new StandardPricingPolicy();
    }

    @Override
    public CancellationPolicy creaetCancellationPolicy() {
        return new StrictCancellationPolicy();
    }
}
// Koniec, Tydzień 2, Wzorzec Abstract factory
