package com.unicorn.my_little_pony.domain.facades.rental.services;

// Tydzień 4, Wzorzec Facade
// Serwis tworzący wypożyczenie.


import com.unicorn.my_little_pony.util.IdGenerator;

public class RentalCreationService {

    public String createRental(String unicornId, String customerId, double price) {
        String rentalId = IdGenerator.getInstance().nextRentalId();
        System.out.println("Rental created: " + rentalId + " for customer " + customerId + ". Price: " + price);
        return rentalId;
    }
}

//Koniec Tydzień 4, Wzorzec Facade
