package com.unicorn.my_little_pony.domain.models.rental.iterator;

import com.unicorn.my_little_pony.domain.models.rental.Rental;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 2
// Interfejs iteratora dla kolekcji wypożuczen, który pozwala na iterowanie po wypozyczeniach o określonym statusie.
public interface RentalIterator {
    boolean hasNext();
    Rental next();
}
// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 2