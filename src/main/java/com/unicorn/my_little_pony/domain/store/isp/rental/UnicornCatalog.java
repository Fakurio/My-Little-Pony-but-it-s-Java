package com.unicorn.my_little_pony.domain.store.isp.rental;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.List;

// Tydzien 8, ISP, Zastosowanie 1
// Interfejs po segregacji: tylko katalog
public interface UnicornCatalog {
    List<Unicorn> getAvailableUnicorns();
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1
