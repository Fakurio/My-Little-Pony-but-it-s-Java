package com.unicorn.my_little_pony.domain.facades.rental;

import com.unicorn.my_little_pony.domain.facades.rental.services.UnicornAvailabilityService;
import com.unicorn.my_little_pony.domain.facades.rental.services.PricingService;
import com.unicorn.my_little_pony.domain.facades.rental.services.RentalCreationService;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

// Tydzień 4, Wzorzec Facade
// Fasada upraszczająca proces wypożyczenia jednorożca.

    public class UnicornRentalFacade {

        private UnicornAvailabilityService availabilityService = new UnicornAvailabilityService();
        private PricingService pricingService = new PricingService();
        private RentalCreationService rentalCreationService = new RentalCreationService();

        public String rentUnicorn(Unicorn unicorn, String customerId) {

            if (!availabilityService.isAvailable(unicorn)) {
                return "Unicorn not available";
            }

            double price = pricingService.calculatePrice(unicorn.getId());

            String rentalId = rentalCreationService.createRental(unicorn.getId(), customerId);


            unicorn.setStatus(UnicornStatus.RENTED);

            return rentalId;
        }
    }
//Koniec Tydzień 4, Wzorzec Facade