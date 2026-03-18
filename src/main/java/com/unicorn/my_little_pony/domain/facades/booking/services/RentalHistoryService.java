package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis historii wypożyczeń klienta.

import com.unicorn.my_little_pony.database.DatabaseRentingHistoryLoader;
import com.unicorn.my_little_pony.database.RentingHistoryLoader;
import com.unicorn.my_little_pony.domain.models.rental.Rental;

import java.util.List;

public class RentalHistoryService {

    private RentingHistoryLoader loader = new DatabaseRentingHistoryLoader();

    public List<Rental> checkHistory(String unicornId) {

        System.out.println("Fetching rental history for unicorn: " + unicornId);

        List<Rental> history = loader.fetchRentingHistory(unicornId);

        System.out.println("History size: " + history.size());

        return history;
    }
}
//Koniec Tydzień 4, Wzorzec Facade