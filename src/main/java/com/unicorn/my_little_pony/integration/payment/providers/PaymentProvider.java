package com.unicorn.my_little_pony.integration.payment.providers;

//Tydzień 8, DI, Zastosowanie 1
//Interfejs definiujący wymagania dla modułu wysokopoziomowego
public interface PaymentProvider {
    boolean process(double amount);
}
//Koniec, Tydzień 8, DI