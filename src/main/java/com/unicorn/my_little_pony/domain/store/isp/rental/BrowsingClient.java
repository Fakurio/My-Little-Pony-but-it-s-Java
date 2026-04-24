package com.unicorn.my_little_pony.domain.store.isp.rental;

// Tydzien 8, ISP, Zastosowanie 1
// Klient po segregacji zalezy tylko od katalogu
public class BrowsingClient {
    private final UnicornCatalog unicornCatalog;

    public BrowsingClient(UnicornCatalog unicornCatalog) {
        this.unicornCatalog = unicornCatalog;
    }

    public void showAvailableCount() {
        int count = unicornCatalog.getAvailableUnicorns().size();
        System.out.println("[ISP] Dostepnych jednorozcow: " + count);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

