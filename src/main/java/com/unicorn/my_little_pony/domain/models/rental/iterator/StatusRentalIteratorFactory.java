package com.unicorn.my_little_pony.domain.models.rental.iterator;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

import java.util.List;

//Tydzień 7, Zasada pojedynczej odpoweidzialności, Zastosowanie 2
// Klasa fabryki iteratorów, która tworzy instancje StatusRentalIterator.
// Po zastosowaniu zasady pojedynczej odpowiedzialności, klasa StatusRentalIteratorFactory jest odpowiedzialna tylko
// za tworzenie instancji iteratora
public class StatusRentalIteratorFactory implements RentalIteratorFactory {

    @Override
    public RentalIterator create(List<Rental> rentals, RentalStatus status) {
        return new StatusRentalIterator(rentals, status);
    }
}
// Koniec, Tydzień 7, Zasada pojedynczej odpowiedzialności, Zastosowanie 2