package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

// Tydzien 8, ISP, Zastosowanie 3
// Klient po segregacji - zalezy tylko od wynajmu
public class RentalAgent {
    private final RentalLifecycle rentalLifecycle;

    public RentalAgent(RentalLifecycle rentalLifecycle) {
        this.rentalLifecycle = rentalLifecycle;
    }

    public void processNewRental(String rentalId) {
        System.out.println("[ISP] Agent: Processing rental");
        rentalLifecycle.confirmRental(rentalId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
