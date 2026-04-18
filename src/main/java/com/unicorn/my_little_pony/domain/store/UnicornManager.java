package com.unicorn.my_little_pony.domain.store;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.repositories.UnicornRepository;
import lombok.Setter;

import java.util.List;

//Tydzień 8, DI, Zastosowanie 2
//Moduł wysokopoziomowy uzyskuje dostęp do repozytorium poprzez interfejs -> nie wie czy czyta z pliku czy z bazy
@Setter
public class UnicornManager {
    private UnicornRepository unicornRepository;

    public UnicornManager(UnicornRepository unicornRepository) {
        this.unicornRepository = unicornRepository;
    }

    public List<Unicorn> getUnicorns() {
        return this.unicornRepository.getAllUnicorn();
    }
}
//Koniec, Tydzień 8, DI