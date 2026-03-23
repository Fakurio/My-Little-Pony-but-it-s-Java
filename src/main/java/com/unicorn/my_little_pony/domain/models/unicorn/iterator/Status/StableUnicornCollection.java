package com.unicorn.my_little_pony.domain.models.unicorn.iterator.Status;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 1
// Implementacja kolekcji jednorożców, zawierająca klasę wewnętrzną iteratora, który filtruje jednorożce na podstawie ich statusu.
public class StableUnicornCollection implements UnicornCollection {

    private final List<Unicorn> unicorns = new ArrayList<>();

    @Override
    public void addUnicorn(Unicorn unicorn) {
        if (unicorn == null) {
            throw new IllegalArgumentException("Unicorn cannot be null");
        }
        unicorns.add(unicorn);
    }

    @Override
    public UnicornIterator createIterator(UnicornStatus status) {
        return new StatusUnicornIterator(unicorns, status);
    }

    private class StatusUnicornIterator implements UnicornIterator {

        private final List<Unicorn> unicorns;
        private final UnicornStatus status;
        private int position;

        public StatusUnicornIterator(List<Unicorn> unicorns, UnicornStatus status) {
            if (unicorns == null) {
                throw new IllegalArgumentException("Unicorn list cannot be null");
            }
            if (status == null) {
                throw new IllegalArgumentException("Status cannot be null");
            }

            this.unicorns = unicorns;
            this.status = status;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            while (position < unicorns.size()) {
                Unicorn unicorn = unicorns.get(position);
                if (unicorn.getStatus() == status) {
                    return true;
                }
                position++;
            }
            return false;
        }

        @Override
        public Unicorn next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more unicorns with status: " + status);
            }
            return unicorns.get(position++);
        }
    }
}

// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 1