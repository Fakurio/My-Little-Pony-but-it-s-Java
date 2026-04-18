package com.unicorn.my_little_pony.integration.payment.providers;

//Tydzień 8, DI, Zastosowanie 1
//Implementacja modułu niskopoziomowego zgodna z wymaganiami modułu wysokopoziomowego
public class StripeProvider implements PaymentProvider {

    @Override
    public boolean process(double amount) {
        System.out.println("Processing request with Stripe for " + amount + " PLN");
        return true;
    }
}
//Koniec, Tydzień 8, DI