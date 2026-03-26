package com.unicorn.my_little_pony.domain.facades.rental;

import com.unicorn.my_little_pony.domain.facades.rental.services.UnicornAvailabilityService;
import com.unicorn.my_little_pony.domain.facades.rental.services.PricingService;
import com.unicorn.my_little_pony.domain.facades.rental.services.RentalCreationService;
import com.unicorn.my_little_pony.domain.models.unicorn.commands.ChangeStatusCommand;
import com.unicorn.my_little_pony.domain.models.unicorn.commands.TransactionMacro;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

// Tydzień 4, Wzorzec Facade
// Fasada upraszczająca proces wypożyczenia jednorożca.

    public class UnicornRentalFacade {

        private final UnicornAvailabilityService availabilityService = new UnicornAvailabilityService();
        private final PricingService pricingService = new PricingService();
        private final RentalCreationService rentalCreationService = new RentalCreationService();

        public String rentUnicorn(Unicorn unicorn, String customerId) {
            if (!availabilityService.isAvailable(unicorn)) {
                return "Unicorn not available";
            }

            // Tydzień 5, Wzorzec Command, Zastosowanie 3
            // Dodanie zadania do transakcji i jego cofnięcię w przypadku błędu
            TransactionMacro transactionMacro = new TransactionMacro();
            try {
                transactionMacro.executeCommand(new ChangeStatusCommand(unicorn, UnicornStatus.RENTED));
                double price = pricingService.calculatePrice(unicorn.getId());
                return rentalCreationService.createRental(unicorn.getId(), customerId);
            } catch (Exception e) {
                transactionMacro.undo();
                return "Error during checkout: " + e.getMessage();
            }
            // Koniec, Tydzień 5, Wzorzec Command
        }
    }
//Koniec Tydzień 4, Wzorzec Facade