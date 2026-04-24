package com.unicorn.my_little_pony.domain.store.isp.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Klient po segregacji - zalezy tylko od pielegnacji
public class GroomerWorker {
    private final UnicornGroomingService groomingService;

    public GroomerWorker(UnicornGroomingService groomingService) {
        this.groomingService = groomingService;
    }

    public void prepareUnicorn(String unicornId) {
        System.out.println("[ISP] Groomer: Starting preparation");
        groomingService.groom(unicornId);
        groomingService.bath(unicornId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2

