package com.unicorn.my_little_pony.domain.store.fat.rental;

// Tydzien 8, ISP, Zastosowanie 1
// Przyklad klienta zaleznego od zbyt szerokiego kontraktu
// Klient potrzebuje tylko platnosci, ale zalezy od wszystkich metod interfejsu.
public class FatCheckoutClient {
    private final UnicornRentalOperations operations;

    public FatCheckoutClient(UnicornRentalOperations operations) {
        this.operations = operations;
    }

    public void checkout(double amount) {
        boolean success = operations.processPayment(amount);
        System.out.println("[FAT] Platnosc " + (success ? "zaakceptowana" : "odrzucona"));
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

