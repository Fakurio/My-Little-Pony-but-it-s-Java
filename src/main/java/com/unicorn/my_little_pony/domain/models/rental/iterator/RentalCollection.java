package com.unicorn.my_little_pony.domain.models.rental.iterator;


import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 2
// Abstrakcyjna kolekcja wypzyczeń, która pozwala na dodawanie wypożyczeń i tworzenie iteratora na podstawie ich statusu.
public interface RentalCollection {
    void addRental(Rental rental);
    RentalIterator createIterator(RentalStatus status);
}
// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 2