package com.unicorn.my_little_pony.domain.models.unicorn.iterator.PowerLevel;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.PowerLevelCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Tydzień 5, Wzorzec Iterator, Zastosowanie 3
// Konkretna implementacja kolekcji jednorożców, która przechowuje jednorożce i pozwala na tworzenie iteratora na podstawie ich poziomu mocy.
public class UnicornPowerBook implements PowerLevelUnicornCollection {

    private final List<Unicorn> unicorns = new ArrayList<>();

    @Override
    public void addUnicorn(Unicorn unicorn) {
        if (unicorn == null) {
            throw new IllegalArgumentException("Unicorn cannot be null");
        }
        unicorns.add(unicorn);
    }

    @Override
    public PowerLevelUnicornIterator createIterator(PowerLevelCategory category) {
        return new CategoryPowerUnicornIterator(unicorns, category);
    }

    private class CategoryPowerUnicornIterator implements PowerLevelUnicornIterator {

        private final List<Unicorn> unicorns;
        private final PowerLevelCategory category;
        private int position;

        public CategoryPowerUnicornIterator(List<Unicorn> unicorns, PowerLevelCategory category) {
            if (unicorns == null) {
                throw new IllegalArgumentException("Unicorn list cannot be null");
            }
            if (category == null) {
                throw new IllegalArgumentException("Power level category cannot be null");
            }

            this.unicorns = unicorns;
            this.category = category;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            while (position < unicorns.size()) {
                Unicorn unicorn = unicorns.get(position);
                if (unicorn.getPowerLevelCategory() == category) {
                    return true;
                }
                position++;
            }
            return false;
        }

        @Override
        public Unicorn next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more unicorns in category: " + category);
            }
            return unicorns.get(position++);
        }
    }
}

// Koniec, Tydzień 5, Wzorzec Iterator, Zastosowanie 3
