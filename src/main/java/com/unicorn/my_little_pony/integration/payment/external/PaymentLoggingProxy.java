package com.unicorn.my_little_pony.integration.payment.external;

import lombok.AllArgsConstructor;

// Tydzień 4, Wzorzec Proxy, Zastosowanie 2
// Proxy loggera dla wszystkich płatności w systemie
@AllArgsConstructor
public class PaymentLoggingProxy implements PaymentService {
    private final PaymentService paymentService;

    @Override
    public void pay(double amount) {
        System.out.println("[PAYMENT LOG] Initiating payment transaction for amount: $" + amount);
        long startTime = System.currentTimeMillis();

        try {
            paymentService.pay(amount);
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("[PAYMENT LOG] Transaction SUCCESS. Processed in " + duration + "ms.");
        } catch (Exception e) {
            System.err.println("[PAYMENT LOG] Transaction FAILED: " + e.getMessage());
            throw e;
        }
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy