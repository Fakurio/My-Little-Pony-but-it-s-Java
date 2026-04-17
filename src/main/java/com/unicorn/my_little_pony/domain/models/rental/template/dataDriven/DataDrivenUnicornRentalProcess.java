package com.unicorn.my_little_pony.domain.models.rental.template.dataDriven;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)
// Klasa realizująca proces wypożyczenia jednorożca.
// Nie zawiera na stałe zakodowanej sekwencji kroków tylko wykonuje je na podstawie konfiguracji przekazanej
// w obiekcie RentalProcessConfig.
public class DataDrivenUnicornRentalProcess {

    private final RentalProcessConfig config;
    private final Map<String, Consumer<String>> stepHandlers;

    public DataDrivenUnicornRentalProcess(RentalProcessConfig config, Map<String, Consumer<String>> stepHandlers) {
        if (config == null) {
            throw new IllegalArgumentException("Rental process config cannot be null");
        }
        if (stepHandlers == null || stepHandlers.isEmpty()) {
            throw new IllegalArgumentException("Step handlers cannot be null or empty");
        }

        this.config = config;
        this.stepHandlers = validateAndCopyHandlers(stepHandlers);
    }

    public final void processRental() {
        for (RentalStep step : config.getSteps()) {
            if (!step.isEnabled()) {
                continue;
            }

            executeStep(step);
        }
    }

    // Wykonuje pojedynczy krok procesu na podstawie jego typu, korzystając z zarejestrowanych handlerów
    private void executeStep(RentalStep step) {
        Consumer<String> handler = stepHandlers.get(step.getType());
        if (handler == null) {
            throw new IllegalArgumentException("No handler registered for rental step type: " + step.getType());
        }

        handler.accept(step.getMessage());
    }

    // Walidacja i stworzenie niemutowalnej kopii mapy handlerów, aby zapewnić bezpieczeństwo i integralność danych
    private static Map<String, Consumer<String>> validateAndCopyHandlers(Map<String, Consumer<String>> stepHandlers) {
        Map<String, Consumer<String>> safeCopy = new HashMap<>();
        for (Map.Entry<String, Consumer<String>> entry : stepHandlers.entrySet()) {
            String stepType = Objects.requireNonNull(entry.getKey(), "Rental step handler key cannot be null");
            if (stepType.isBlank()) {
                throw new IllegalArgumentException("Rental step handler key cannot be blank");
            }

            Consumer<String> handler = Objects.requireNonNull(entry.getValue(), "Rental step handler cannot be null");
            safeCopy.put(stepType, handler);
        }

        return Collections.unmodifiableMap(safeCopy);
    }
}
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)