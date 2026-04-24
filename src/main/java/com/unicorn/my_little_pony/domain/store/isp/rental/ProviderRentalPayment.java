package com.unicorn.my_little_pony.domain.store.isp.rental;

import com.unicorn.my_little_pony.integration.payment.providers.PaymentProvider;

// Tydzien 8, ISP, Zastosowanie 1
// Implementacja malego kontraktu platnosci
public class ProviderRentalPayment implements RentalPayment {

    private final PaymentProvider paymentProvider;

    public ProviderRentalPayment(PaymentProvider paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

    @Override
    public boolean processPayment(double amount) {
        return paymentProvider.process(amount);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

