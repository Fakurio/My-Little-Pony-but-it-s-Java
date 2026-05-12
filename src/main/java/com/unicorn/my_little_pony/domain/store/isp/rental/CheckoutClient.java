package com.unicorn.my_little_pony.domain.store.isp.rental;

// Tydzien 8, ISP, Zastosowanie 1
// Klient po segregacji zalezy tylko od platnosci
public class CheckoutClient {
    private final RentalPayment rentalPayment;

    public CheckoutClient(RentalPayment rentalPayment) {
        this.rentalPayment = rentalPayment;
    }

    public void checkout(double amount) {
        rentalPayment.processPayment(amount);
        System.out.println("[ISP] Platnosc zaakceptowana");
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1
