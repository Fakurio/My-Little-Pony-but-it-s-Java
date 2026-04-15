package com.unicorn.my_little_pony.domain.models.rental.iterator;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.enums.RentalStatus;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 2
// Implementacja kolekcji wypożyczeń, zawierająca klasę wewnętrzną iteratora, który filtruje wypożyczenia na podstawie ich statusu.

public class RentalBook implements RentalCollection {

    private final List<Rental> rentals = new ArrayList<>();
    private final RentalIteratorFactory iteratorFactory;

    public RentalBook() {
        this(new StatusRentalIteratorFactory());
    }

    public RentalBook(RentalIteratorFactory iteratorFactory) {
        if (iteratorFactory == null) {
            throw new IllegalArgumentException("Iterator factory cannot be null");
        }
        this.iteratorFactory = iteratorFactory;
    }

    @Override
    public void addRental(Rental rental) {
        if (rental == null) {
            throw new IllegalArgumentException("Rental cannot be null");
        }
        rentals.add(rental);
    }

    @Override
    public RentalIterator createIterator(RentalStatus status) {
        return this.iteratorFactory.create(rentals, status);
    }
// Tydzień 7, Zasada pojedynczej odpowiedzialności, Zastosowanie 2
// Przed implementacja zasady pojedynczej odpowiedzialnosci klasa RentalBook zawierała zarówno logikę zarządzania kolekcją wypożyczeń,
// jak i logikę iterowania po nich. Po zastosowaniu zasady pojedynczej odpowiedzialności, klasa RentalBook jest odpowiedzialna tylko za
// zarządzanie kolekcją wypożyczeń, a klasa StatusRentalIterator jest odpowiedzialna za iterowanie po tej kolekcji na podstawie statusu wypożyczenia.
// Dzięki temu każda klasa ma jasno określoną odpowiedzialność, co ułatwia utrzymanie i rozwijanie kodu.
//    private class StatusRentalIterator implements RentalIterator {
//
//        private final List<Rental> rentals;
//        private final RentalStatus status;
//        private int position;
//
//        public StatusRentalIterator(List<Rental> rentals, RentalStatus status) {
//            if (rentals == null) {
//                throw new IllegalArgumentException("Rental list cannot be null");
//            }
//            if (status == null) {
//                throw new IllegalArgumentException("Rental status cannot be null");
//            }
//
//            this.rentals = rentals;
//            this.status = status;
//            this.position = 0;
//        }
//
//        @Override
//        public boolean hasNext() {
//            while (position < rentals.size()) {
//                Rental rental = rentals.get(position);
//                if (rental.getStatus() == status) {
//                    return true;
//                }
//                position++;
//            }
//            return false;
//        }
//
//        @Override
//        public Rental next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException("No more rentals with status: " + status);
//            }
//            return rentals.get(position++);
//        }
//    }
}
//Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 2