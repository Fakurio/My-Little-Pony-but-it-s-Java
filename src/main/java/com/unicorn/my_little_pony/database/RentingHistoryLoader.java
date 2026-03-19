package com.unicorn.my_little_pony.database;

import com.unicorn.my_little_pony.domain.models.rental.Rental;

import java.util.List;

// Tydzień 4, Wzorzec Proxy, Zastosowanie 3
// Wspólny interfejs dla proxy pamięci podręcznej oraz klasy ładującej historie wypożyczeń
public interface RentingHistoryLoader {
    List<Rental> fetchRentingHistory(String unicornId);
}
// Koniec, Tydzień 4, Wzorzec Proxy