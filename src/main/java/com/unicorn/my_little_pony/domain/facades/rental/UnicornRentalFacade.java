package com.unicorn.my_little_pony.domain.facades.rental;

import com.unicorn.my_little_pony.domain.exceptions.RentalCheckoutException;
import com.unicorn.my_little_pony.domain.exceptions.UnicornNotAvailableException;
import com.unicorn.my_little_pony.domain.facades.rental.services.RainbowPricingRule;
import com.unicorn.my_little_pony.domain.facades.rental.services.UnicornAvailabilityService;
import com.unicorn.my_little_pony.domain.facades.rental.services.PricingService;
import com.unicorn.my_little_pony.domain.facades.rental.services.RentalCreationService;
import com.unicorn.my_little_pony.domain.models.unicorn.commands.ChangeStatusCommand;
import com.unicorn.my_little_pony.domain.models.unicorn.commands.TransactionMacro;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

import java.util.List;

// Tydzień 4, Wzorzec Facade
// Fasada upraszczająca proces wypożyczenia jednorożca.

    public class UnicornRentalFacade {

        private final UnicornAvailabilityService availabilityService = new UnicornAvailabilityService();
        private final PricingService pricingService = new PricingService(
                List.of(new RainbowPricingRule())
        );
        private final RentalCreationService rentalCreationService = new RentalCreationService();

        public String rentUnicorn(Unicorn unicorn, String customerId) {
            if (!availabilityService.isAvailable(unicorn)) {
                throw new UnicornNotAvailableException(unicorn.getName());
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
                throw new RentalCheckoutException(e.getMessage(), e);
            }
            // Koniec, Tydzień 5, Wzorzec Command
        }
    }
//Koniec Tydzień 4, Wzorzec Facade