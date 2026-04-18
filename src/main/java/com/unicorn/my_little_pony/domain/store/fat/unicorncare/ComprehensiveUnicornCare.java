package com.unicorn.my_little_pony.domain.store.fat.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Fat interface - miesza pielegnacje, zdrowie, trening
public interface ComprehensiveUnicornCare {
    void groom(String unicornId);
    void bath(String unicornId);
    void checkHealth(String unicornId);
    void treatInjury(String unicornId, String injury);
    void trainBasics(String unicornId);
    void trainAdvanced(String unicornId);
    String getReport(String unicornId);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2

