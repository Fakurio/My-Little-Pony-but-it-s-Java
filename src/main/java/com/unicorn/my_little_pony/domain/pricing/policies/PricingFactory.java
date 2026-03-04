package com.unicorn.my_little_pony.domain.pricing.policies;

import com.unicorn.my_little_pony.domain.pricing.policies.cancellation.CancellationPolicy;
import com.unicorn.my_little_pony.domain.pricing.policies.pricing.PricingPolicy;

// Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3
// Interfejs reprezentujący obiekty wchodzące w skład planu cenowego
public interface PricingFactory {
    PricingPolicy creaetPricingPolicy();
    CancellationPolicy creaetCancellationPolicy();
}
// Koniec, Tydzień 2, Wzorzec Abstract factory, Zastosowanie 3