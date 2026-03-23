package com.unicorn.my_little_pony.domain.models.unicorn.iterator.PowerLevel;


import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 3
// Interfejs iteratora dla kolekcji jednorożców, który pozwala na iterowanie po jednorożcach o określonym poziomie mocy.
public interface PowerLevelUnicornIterator {
    boolean hasNext();
    Unicorn next();
}

// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 3
