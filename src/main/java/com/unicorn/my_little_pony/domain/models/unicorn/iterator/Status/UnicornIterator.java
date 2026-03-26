package com.unicorn.my_little_pony.domain.models.unicorn.iterator.Status;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 1
// Interfejs iteratora dla kolekcji jednorożców, który pozwala na iterowanie po jednorożcach o określonym statusie.
public interface UnicornIterator {
    boolean hasNext();
    Unicorn next();
}
// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 1