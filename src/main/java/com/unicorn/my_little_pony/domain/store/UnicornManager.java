package com.unicorn.my_little_pony.domain.store;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.repositories.UnicornRepository;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

//Tydzień 8, DI, Zastosowanie 2
//Moduł wysokopoziomowy uzyskuje dostęp do repozytorium poprzez interfejs -> nie wie czy czyta z pliku czy z bazy
@Setter
public class UnicornManager {
    private UnicornRepository unicornRepository;

    public UnicornManager(UnicornRepository unicornRepository) {
        this.unicornRepository = unicornRepository;
    }

    public List<Unicorn> getUnicorns() {
        return this.unicornRepository.getAllUnicorns();
    }

    //Tydzień 10, Użycie interfejsu funkcyjnego do filtrowania jednorożców
    public List<Unicorn> filterUnicorns(UnicornFilter filter) {
        List<Unicorn> filtered = new ArrayList<>();
        for (Unicorn unicorn : getUnicorns()) {
            if (filter.apply(unicorn)) {
                filtered.add(unicorn);
            }
        }
        return filtered;
    }
    //Koniec, Tydzień 10
}
//Koniec, Tydzień 8, DI
