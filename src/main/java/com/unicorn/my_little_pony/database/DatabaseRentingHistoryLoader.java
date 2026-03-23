package com.unicorn.my_little_pony.database;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Tydzień 4, Wzorzec Proxy, Zastosowanie 3
// Klasa wykonująca długą operację wczytywania historii wypożyczeń z bazy danych
public class DatabaseRentingHistoryLoader implements RentingHistoryLoader {
    @Override
    public List<Rental> fetchRentingHistory(String unicornId) {
        System.out.println("[DATABASE] Connecting to the rental archive...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<Rental> history = new ArrayList<>();
        history.add(new Rental(
                "R-1001", unicornId, "CUST-99",
                LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(8),
                200.0, 180.0, true, RentalStatus.NEW
        ));
        history.add(new Rental(
                "R-1002", unicornId, "CUST-42",
                LocalDateTime.now().minusDays(5), LocalDateTime.now().minusDays(2),
                300.0, 300.0, true, RentalStatus.NEW
        ));

        return history;
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy