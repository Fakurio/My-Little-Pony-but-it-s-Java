package com.unicorn.my_little_pony.domain.models.rental.template.dataDriven;

// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)
// Klasa reprezentująca pojedynczy krok procesu wypożyczenia.
// Jest to czysta struktura danych, która nie zawiera logiki, tylko opisuje co ma zostać wykonane.
public class RentalStep {

    private final String type;
    private final String message;
    private final boolean enabled;

    public RentalStep(String type, String message, boolean enabled) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Rental step type cannot be null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Rental step message cannot be null or blank");
        }

        this.type = type;
        this.message = message;
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)