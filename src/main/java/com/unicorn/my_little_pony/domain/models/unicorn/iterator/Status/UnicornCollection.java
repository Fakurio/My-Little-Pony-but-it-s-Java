package com.unicorn.my_little_pony.domain.models.unicorn.iterator.Status;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 1
// Abstrakcyjna kolekcja jednorożców, która pozwala na dodawanie jednorożców i tworzenie iteratora na podstawie ich statusu.
public interface UnicornCollection {

    void addUnicorn(Unicorn unicorn);

    UnicornIterator createIterator(UnicornStatus status);
}
// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 1