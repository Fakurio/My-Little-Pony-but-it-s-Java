package com.unicorn.my_little_pony.domain.models.rental.iterator;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

import java.util.List;
import java.util.NoSuchElementException;

//Tydzień 7, Zasada pojedynczej odpoweidzialności, Zastosowanie 2
// Klasa wewnętrzna iteratora, która filtruje wypożyczenia na podstawie ich statusu.
// Po zastosowaniu zasady pojedynczej odpowiedzialności, klasa już nie jest wewnętrzna, a samodzielną klasą
// odpowiedzialną tylko za iterowanie po kolekcji wypożyczeń na podstawie statusu wypożyczenia.
public class StatusRentalIterator implements RentalIterator {

    private final List<Rental> rentals;
    private final RentalStatus status;
    private int position;

    public StatusRentalIterator(List<Rental> rentals, RentalStatus status) {
        if (rentals == null) {
            throw new IllegalArgumentException("Rental list cannot be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("Rental status cannot be null");
        }

        this.rentals = List.copyOf(rentals);
        this.status = status;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        while (position < rentals.size()) {
            Rental rental = rentals.get(position);
            if (rental.getStatus() == status) {
                return true;
            }
            position++;
        }
        return false;
    }

    @Override
    public Rental next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more rentals with status: " + status);
        }
        return rentals.get(position++);
    }
}
// Koniec, Tydzień 7, Zasada pojedynczej odpowiedzialności, Zastosowanie 2