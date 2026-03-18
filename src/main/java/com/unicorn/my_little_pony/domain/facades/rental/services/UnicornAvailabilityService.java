package com.unicorn.my_little_pony.domain.facades.rental.services;

// Tydzień 4, Wzorzec Facade
// Serwis sprawdzający dostępność jednorożca.

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

public class UnicornAvailabilityService {

    public boolean isAvailable(Unicorn unicorn) {

        boolean available = unicorn.getStatus() == UnicornStatus.AVAILABLE;

        System.out.println("Checking availability for " + unicorn.getName() + ": " + available);

        return available;
    }
}
//Koniec Tydzień 4, Wzorzec Facade