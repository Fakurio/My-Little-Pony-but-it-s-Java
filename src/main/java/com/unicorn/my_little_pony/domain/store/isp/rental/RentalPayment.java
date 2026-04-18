package com.unicorn.my_little_pony.domain.store.isp.rental;

// Tydzien 8, ISP, Zastosowanie 1
// Interfejs po segregacji: tylko platnosc
public interface RentalPayment {
    boolean processPayment(double amount);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

