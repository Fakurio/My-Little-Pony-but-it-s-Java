package com.unicorn.my_little_pony.domain.store.isp.rental;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.repositories.UnicornRepository;

import java.util.List;

// Tydzien 8, ISP, Zastosowanie 1
// Implementacja malego kontraktu katalogu
public class RepositoryUnicornCatalog implements UnicornCatalog {

    private final UnicornRepository unicornRepository;

    public RepositoryUnicornCatalog(UnicornRepository unicornRepository) {
        this.unicornRepository = unicornRepository;
    }

    @Override
    public List<Unicorn> getAvailableUnicorns() {
        return unicornRepository.getAllUnicorn();
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1
