package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis historii wypożyczeń klienta.

import com.unicorn.my_little_pony.database.DatabaseRentalHistoryLoader;
import com.unicorn.my_little_pony.database.RentalHistoryLoader;
import com.unicorn.my_little_pony.domain.models.rental.Rental;

import java.util.List;

public class RentalHistoryService {

    private final RentalHistoryLoader rentalHistoryLoader;

    public RentalHistoryService() {
        this(new DatabaseRentalHistoryLoader());
    }

    public RentalHistoryService(RentalHistoryLoader rentalHistoryLoader) {
        this.rentalHistoryLoader = rentalHistoryLoader;
    }

    public List<Rental> getRentalHistory(String unicornId) {
        System.out.println("Fetching rental history for unicorn: " + unicornId);
        List<Rental> rentalHistory = rentalHistoryLoader.fetchRentalHistory(unicornId);
        System.out.println("History size: " + rentalHistory.size());
        return rentalHistory;
    }
}
//Koniec Tydzień 4, Wzorzec Facade
