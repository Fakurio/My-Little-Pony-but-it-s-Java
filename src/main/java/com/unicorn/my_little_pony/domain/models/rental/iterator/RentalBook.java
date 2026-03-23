package com.unicorn.my_little_pony.domain.models.rental.iterator;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 2
// Implementacja kolekcji wypożyczeń, zawierająca klasę wewnętrzną iteratora, który filtruje wypożyczenia na podstawie ich statusu.

public class RentalBook implements RentalCollection {

    private final List<Rental> rentals = new ArrayList<>();

    @Override
    public void addRental(Rental rental) {
        if (rental == null) {
            throw new IllegalArgumentException("Rental cannot be null");
        }
        rentals.add(rental);
    }

    @Override
    public RentalIterator createIterator(RentalStatus status) {
        return new StatusRentalIterator(rentals, status);
    }

    private class StatusRentalIterator implements RentalIterator {

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

            this.rentals = rentals;
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
}
//Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 2