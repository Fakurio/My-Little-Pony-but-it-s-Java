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
            ensureUnicornIsAvailable(unicorn);
            TransactionMacro transactionMacro = createRentalTransaction();
            try {
                markUnicornAsRented(transactionMacro, unicorn);
                return createRental(unicorn, customerId);
            } catch (Exception e) {
                return rollbackAndThrow(transactionMacro, e);
            }
        }

        private void ensureUnicornIsAvailable(Unicorn unicorn) {
            if (!availabilityService.isAvailable(unicorn)) {
                throw new UnicornNotAvailableException(unicorn.getName());
            }
        }

        private TransactionMacro createRentalTransaction() {
            return new TransactionMacro();
        }

        private void markUnicornAsRented(TransactionMacro transactionMacro, Unicorn unicorn) {
            transactionMacro.executeCommand(new ChangeStatusCommand(unicorn, UnicornStatus.RENTED));
        }

        private String createRental(Unicorn unicorn, String customerId) {
            double price = pricingService.calculatePrice(unicorn.getId());
            return rentalCreationService.createRental(unicorn.getId(), customerId, price);
        }

        private String rollbackAndThrow(TransactionMacro transactionMacro, Exception exception) {
            transactionMacro.undo();
            throw new RentalCheckoutException(exception.getMessage(), exception);
        }
    }
//Koniec Tydzień 4, Wzorzec Facade
