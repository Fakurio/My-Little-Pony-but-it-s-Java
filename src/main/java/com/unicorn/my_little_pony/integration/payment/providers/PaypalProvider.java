package com.unicorn.my_little_pony.integration.payment.providers;

import com.unicorn.my_little_pony.domain.exceptions.PaymentProcessingException;
import com.unicorn.my_little_pony.aspect.exceptiontranslation.TranslateExceptions;

//Tydzień 8, DI, Zastosowanie 1
//Implementacja modułu niskopoziomowego zgodna z wymaganiami modułu wysokopoziomowego
@TranslateExceptions
public class PaypalProvider implements PaymentProvider {
    private static final double MINIMUM_PAYMENT_AMOUNT = 0.0;

    @Override
    public void process(double amount) {
        if (amount <= MINIMUM_PAYMENT_AMOUNT) {
            throw new PaymentProcessingException("Payment amount must be positive.");
        }
        System.out.println("Processing request using Paypal for " + amount + " PLN");
    }
}
//Koniec, Tydzień 8, DI
