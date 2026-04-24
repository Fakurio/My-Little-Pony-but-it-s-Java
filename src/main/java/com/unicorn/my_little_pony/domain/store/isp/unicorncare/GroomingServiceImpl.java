package com.unicorn.my_little_pony.domain.store.isp.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Implementacja segregated interface - pielegnacja
public class GroomingServiceImpl implements UnicornGroomingService {

    @Override
    public void groom(String unicornId) {
        System.out.println("[ISP] Grooming unicorn " + unicornId);
    }

    @Override
    public void bath(String unicornId) {
        System.out.println("[ISP] Bathing unicorn " + unicornId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2

