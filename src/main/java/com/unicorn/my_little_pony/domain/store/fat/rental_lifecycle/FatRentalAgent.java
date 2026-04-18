package com.unicorn.my_little_pony.domain.store.fat.rental_lifecycle;

// Tydzien 8, ISP, Zastosowanie 3
// Klient (agent) zalezy od calego fat interface, mimo ze uzyta tylko wynajem
public class FatRentalAgent {
    private final CompleteRentalManagement rentalManager;

    public FatRentalAgent(CompleteRentalManagement rentalManager) {
        this.rentalManager = rentalManager;
    }

    public void processNewRental(String rentalId) {
        System.out.println("[FAT] Agent: Processing rental");
        rentalManager.confirmRental(rentalId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
