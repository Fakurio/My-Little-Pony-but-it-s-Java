package com.unicorn.my_little_pony.domain.store.isp.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Klient po segregacji - zalezy tylko od zdrowia
public class VeterinarianWorker {
    private final UnicornHealthService healthService;

    public VeterinarianWorker(UnicornHealthService healthService) {
        this.healthService = healthService;
    }

    public void examineUnicorn(String unicornId) {
        System.out.println("[ISP] Veterinarian: Starting examination");
        healthService.checkHealth(unicornId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2
