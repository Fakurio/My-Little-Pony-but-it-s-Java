package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

// Tydzien 8, ISP, Zastosowanie 3
// Segregated interface - tylko finansowanie
public interface RentalFinance {
    boolean processPayment(String rentalId, double amount);
    double getRefundAmount(String rentalId);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
