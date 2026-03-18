package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis sprawdzający poprawność klienta.

public class CustomerValidationService {

    public boolean validate(String customerId) {

        boolean valid = !customerId.isEmpty();

        System.out.println("Customer valid: " + valid);

        return valid;
    }
}
//Koniec Tydzień 4, Wzorzec Facade