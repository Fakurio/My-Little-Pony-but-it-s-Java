package com.unicorn.my_little_pony.domain.store;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 10, Interfejs funkcyjny do filtrowania jednorożców
@FunctionalInterface
public interface UnicornFilter {
    boolean apply(Unicorn unicorn);
}

//Koniec, Tydzień 10
