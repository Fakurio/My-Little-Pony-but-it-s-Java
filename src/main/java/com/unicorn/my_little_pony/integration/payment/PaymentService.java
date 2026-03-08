package com.unicorn.my_little_pony.integration.payment;

//Tydzień 3, Wzorzec Adapter 1 (przez kompozycję)
//interfejs, który jest znany przez system, ale nie jest kompatybilny z klasą, którą chcemy użyć (ExternalPaymentGateway).
//Adapter będzie implementował interfejs i tłumaczył wywołania na format zrozumiały dla ExternalPaymentGateway.
public interface PaymentService {
    void pay(double amount);
}
//Koniec, Tydzień 3, Wzorzec Adapter 1
