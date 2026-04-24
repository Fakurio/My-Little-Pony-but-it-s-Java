package com.unicorn.my_little_pony.domain.store.fat.rental;

// Tydzien 8, ISP, Zastosowanie 1
// Przyklad klienta zaleznego od zbyt szerokiego kontraktu
// Klient potrzebuje tylko katalogu, ale musi przyjac caly interfejs.
public class FatBrowsingClient {
    private final UnicornRentalOperations operations;

    public FatBrowsingClient(UnicornRentalOperations operations) {
        this.operations = operations;
    }

    public void showAvailableCount() {
        int count = operations.getAvailableUnicorns().size();
        System.out.println("[FAT] Dostepnych jednorozcow: " + count);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

