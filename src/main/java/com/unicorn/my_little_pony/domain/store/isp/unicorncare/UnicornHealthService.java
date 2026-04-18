package com.unicorn.my_little_pony.domain.store.isp.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Segregated interface - tylko zdrowie
public interface UnicornHealthService {
    void checkHealth(String unicornId);
    void treatInjury(String unicornId, String injury);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2
