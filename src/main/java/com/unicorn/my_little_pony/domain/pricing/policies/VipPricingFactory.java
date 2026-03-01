package com.unicorn.my_little_pony.domain.pricing.policies;

import com.unicorn.my_little_pony.domain.pricing.policies.cancellation.CancellationPolicy;
import com.unicorn.my_little_pony.domain.pricing.policies.cancellation.FlexibleCancellationPolicy;
import com.unicorn.my_little_pony.domain.pricing.policies.pricing.PricingPolicy;
import com.unicorn.my_little_pony.domain.pricing.policies.pricing.VipPricingPolicy;

// Tydzień 2, Wzorzec Abstract factory
// Konkretna implementacja danego planu cenowego
public class VipPricingFactory implements PricingFactory {

    @Override
    public PricingPolicy creaetPricingPolicy() {
        return new VipPricingPolicy();
    }

    @Override
    public CancellationPolicy creaetCancellationPolicy() {
        return new FlexibleCancellationPolicy();
    }
}
// Koniec, Tydzień 2, Wzorzec Abstract factory
