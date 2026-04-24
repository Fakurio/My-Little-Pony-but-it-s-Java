package com.unicorn.my_little_pony.domain.store.fat.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Klient (groomer) zalezy od calego fat interface, mimo ze uzyta tylko grooming
public class FatGroomerWorker {
    private final ComprehensiveUnicornCare care;

    public FatGroomerWorker(ComprehensiveUnicornCare care) {
        this.care = care;
    }

    public void prepareUnicorn(String unicornId) {
        System.out.println("[FAT] Groomer: Starting preparation");
        care.groom(unicornId);
        care.bath(unicornId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2

