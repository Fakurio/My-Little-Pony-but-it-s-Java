package com.unicorn.my_little_pony.domain.models.rental.template.dataDriven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)
// Klasa konfiguracyjna procesu wypożyczenia.
// Przechowuje listę kroków, które mają zostać wykonane. Dzięki temu możliwe jest sterowanie przebiegiem procesu poprzez dane,
// bez konieczności modyfikowania logiki w klasie procesu.
public class RentalProcessConfig {

    // Lista kroków procesu w określonej kolejności
    private final List<RentalStep> steps;

    public RentalProcessConfig(List<RentalStep> steps) {
        this.steps = validateAndCopySteps(steps);
    }

    public List<RentalStep> getSteps() {
        return steps;
    }

    // Walidacja i stworzenie niemutowalnej kopii listy kroków
    private static List<RentalStep> validateAndCopySteps(List<RentalStep> steps) {
        if (steps == null || steps.isEmpty()) {
            throw new IllegalArgumentException("Rental process steps cannot be null or empty");
        }

        List<RentalStep> safeCopy = new ArrayList<>();
        for (RentalStep step : steps) {
            safeCopy.add(Objects.requireNonNull(step, "Rental process step cannot be null"));
        }

        return Collections.unmodifiableList(safeCopy);
    }
}
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)