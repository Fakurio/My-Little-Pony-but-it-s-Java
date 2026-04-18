package com.unicorn.my_little_pony.repositories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.List;

//Tydzień 8, DI, Zastosowanie 2
//Interfejs definiujący wymagania dla modułu wysokopoziomowego
public interface UnicornRepository {
    List<Unicorn> getAllUnicorn();
}
//Koniec, Tydzień 8, DI