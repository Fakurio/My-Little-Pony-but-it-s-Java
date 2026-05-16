package com.unicorn.my_little_pony.integration.payment.external;

//Tydzień 3, Wzorzec Adapter 1 (przez kompozycję)
//Adapter, który implementuje interfejs PaymentService i używa ExternalPaymentGateway do realizacji płatności.
public class PaymentAdapter implements PaymentService {

    private static final int CENTS_PER_UNIT = 100;

    private ExternalPaymentGateway externalPaymentGateway = new ExternalPaymentGateway();

    @Override
    public void pay(double amount) {
        int amountInCents = (int) Math.round(amount * CENTS_PER_UNIT);
        System.out.println("[Adapter] Converting amount " + amount + " to cents: " + amountInCents);
        externalPaymentGateway.makePayment(amountInCents);
    }
}
//Koniec, Tydzień 3, Wzorzec Adapter 1
