package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis sprawdzający poprawność klienta.

public class CustomerValidationService {

    public void validateCustomerId(String customerId) {
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID cannot be blank");
        }
        System.out.println("Customer valid: true");
    }
}
//Koniec Tydzień 4, Wzorzec Facade
