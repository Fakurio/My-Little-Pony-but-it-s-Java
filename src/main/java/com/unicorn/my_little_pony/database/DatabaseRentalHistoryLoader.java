package com.unicorn.my_little_pony.database;

import com.unicorn.my_little_pony.domain.models.rental.builders.RentalBuilder;
import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

import java.time.LocalDateTime;
import java.util.List;

// Tydzień 4, Wzorzec Proxy, Zastosowanie 3
// Klasa wykonująca długą operację wczytywania historii wypożyczeń z bazy danych
public class DatabaseRentalHistoryLoader implements RentalHistoryLoader {
    private static final int DATABASE_QUERY_DELAY_MS = 2000;
    private static final String FIRST_RENTAL_ID = "R-1001";
    private static final String FIRST_CUSTOMER_ID = "CUST-99";
    private static final long FIRST_RENTAL_START_OFFSET_DAYS = 10;
    private static final long FIRST_RENTAL_END_OFFSET_DAYS = 8;
    private static final double FIRST_RENTAL_BASE_PRICE = 200.0;
    private static final double FIRST_RENTAL_FINAL_PRICE = 180.0;
    private static final String SECOND_RENTAL_ID = "R-1002";
    private static final String SECOND_CUSTOMER_ID = "CUST-42";
    private static final long SECOND_RENTAL_START_OFFSET_DAYS = 5;
    private static final long SECOND_RENTAL_END_OFFSET_DAYS = 2;
    private static final double SECOND_RENTAL_PRICE = 300.0;

    @Override
    public List<Rental> fetchRentalHistory(String unicornId) {
        System.out.println("[DATABASE] Connecting to the rental archive...");
        pauseForDatabaseQuery();
        return buildRentalHistory(unicornId);
    }

    private void pauseForDatabaseQuery() {
        try {
            Thread.sleep(DATABASE_QUERY_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private List<Rental> buildRentalHistory(String unicornId) {
        LocalDateTime currentTime = LocalDateTime.now();
        return List.of(
                createFirstRental(unicornId, currentTime),
                createSecondRental(unicornId, currentTime)
        );
    }

    private Rental createFirstRental(String unicornId, LocalDateTime currentTime) {
        return new RentalBuilder()
                .id(FIRST_RENTAL_ID)
                .unicornId(unicornId)
                .customerId(FIRST_CUSTOMER_ID)
                .start(currentTime.minusDays(FIRST_RENTAL_START_OFFSET_DAYS))
                .end(currentTime.minusDays(FIRST_RENTAL_END_OFFSET_DAYS))
                .basePrice(FIRST_RENTAL_BASE_PRICE)
                .finalPrice(FIRST_RENTAL_FINAL_PRICE)
                .termsAccepted(true)
                .status(RentalStatus.NEW)
                .build();
    }

    private Rental createSecondRental(String unicornId, LocalDateTime currentTime) {
        return new RentalBuilder()
                .id(SECOND_RENTAL_ID)
                .unicornId(unicornId)
                .customerId(SECOND_CUSTOMER_ID)
                .start(currentTime.minusDays(SECOND_RENTAL_START_OFFSET_DAYS))
                .end(currentTime.minusDays(SECOND_RENTAL_END_OFFSET_DAYS))
                .basePrice(SECOND_RENTAL_PRICE)
                .finalPrice(SECOND_RENTAL_PRICE)
                .termsAccepted(true)
                .status(RentalStatus.NEW)
                .build();
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy
