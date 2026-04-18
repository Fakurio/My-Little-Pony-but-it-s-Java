package com.unicorn.my_little_pony.integration.payment.external;

//Tydzień 3, Wzorzec Adapter 1 (przez kompozycję)
//Klasa, która chcemy użyć, ale jej interfejs jest niekompatybilny z naszym systemem (PaymentService).
public class ExternalPaymentGateway {

    public void makePayment(int amountInCents) {
        System.out.println("External payment gateway: paid " + amountInCents + " cents.");
    }
}
//Koniec, Tydzień 3, Wzorzec Adapter 1
