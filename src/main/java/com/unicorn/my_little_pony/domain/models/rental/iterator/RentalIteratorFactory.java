package com.unicorn.my_little_pony.domain.models.rental.iterator;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

import java.util.List;

// Tydzień 7, Zasada pojedynczej odpowiedzialności, Zastosowanie 2
// Interfejs fabryki iteratorów, który definiuje metodę do tworzenia iteratora
public interface RentalIteratorFactory {
    RentalIterator create(List<Rental> rentals, RentalStatus status);
}
// Koniec, Tydzień 7, Zasada pojedynczej odpowiedzialności, Zastosowanie 2