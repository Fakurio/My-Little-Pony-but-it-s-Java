package com.unicorn.my_little_pony.integration.payment;

import com.unicorn.my_little_pony.integration.payment.providers.PaymentProvider;
import lombok.Setter;

//Tydzień 8, DI, Zastosowanie 1
//Moduł wysokopoziomowy wykorzystujący dany sposób płatności poprzez interfejs
@Setter
public class PaymentProcessor {
    private PaymentProvider provider;

    public PaymentProcessor(PaymentProvider provider) {
        this.provider = provider;
    }

    public boolean pay(double amount) {
        return this.provider.process(amount);
    }
}
//Koniec, Tydzień 8, DI