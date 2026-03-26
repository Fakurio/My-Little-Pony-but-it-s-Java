package com.unicorn.my_little_pony.domain.models.unicorn.iterator.PowerLevel;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.PowerLevelCategory;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 3
// Abstrakcyjna kolekcja jednorożców, która pozwala na dodawanie jednorożców i tworzenie iteratora na podstawie ich poziomu mocy.
public interface PowerLevelUnicornCollection {
    void addUnicorn(Unicorn unicorn);
    PowerLevelUnicornIterator createIterator(PowerLevelCategory category);
}

// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 3
