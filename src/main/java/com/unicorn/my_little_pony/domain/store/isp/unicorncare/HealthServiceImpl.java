package com.unicorn.my_little_pony.domain.store.isp.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Implementacja segregated interface - zdrowie
public class HealthServiceImpl implements UnicornHealthService {

    @Override
    public void checkHealth(String unicornId) {
        System.out.println("[ISP] Checking health of unicorn " + unicornId);
    }

    @Override
    public void treatInjury(String unicornId, String injury) {
        System.out.println("[ISP] Treating " + injury + " on unicorn " + unicornId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2

