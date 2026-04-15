package com.unicorn.my_little_pony.domain.models.rental.template.dataDriven;

// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)
// Klasa realizująca proces wypożyczenia jednorożca.
// Nie zawiera na stałe zakodowanej sekwencji kroków tylko wykonuje je na podstawie konfiguracji przekazanej w obiekcie RentalProcessConfig.
public class DataDrivenUnicornRentalProcess {

    private final RentalProcessConfig config;

    public DataDrivenUnicornRentalProcess(RentalProcessConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("Rental process config cannot be null");
        }
        this.config = config;
    }

    public final void processRental() {
        for (RentalStep step : config.getSteps()) {
            if (!step.isEnabled()) {
                continue;
            }

            executeStep(step);
        }
    }

    private void executeStep(RentalStep step) {
        switch (step.getType()) {
            case VALIDATE_CUSTOMER -> validateCustomer(step.getMessage());
            case CHOOSE_UNICORN -> chooseUnicorn(step.getMessage());
            case CALCULATE_PRICE -> calculatePrice(step.getMessage());
            case PREPARE_AGREEMENT -> prepareAgreement(step.getMessage());
            case RELEASE_UNICORN -> releaseUnicorn(step.getMessage());
            case SEND_NOTIFICATION -> sendNotification(step.getMessage());
        }
    }

    private void validateCustomer(String message) {
        System.out.println(message);
    }

    private void chooseUnicorn(String message) {
        System.out.println(message);
    }

    private void calculatePrice(String message) {
        System.out.println(message);
    }

    private void prepareAgreement(String message) {
        System.out.println(message);
    }

    private void releaseUnicorn(String message) {
        System.out.println(message);
    }

    private void sendNotification(String message) {
        System.out.println(message);
    }
}
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)