package com.unicorn.my_little_pony.domain.facades.booking;

import com.unicorn.my_little_pony.domain.facades.booking.services.CustomerValidationService;
import com.unicorn.my_little_pony.domain.facades.booking.services.LoyaltyPointsService;
import com.unicorn.my_little_pony.domain.facades.booking.services.RecommendationService;
import com.unicorn.my_little_pony.domain.facades.booking.services.RentalHistoryService;
import com.unicorn.my_little_pony.domain.facades.booking.services.DiscountService;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 4, Wzorzec Facade
// Fasada upraszczająca przygotowanie oferty dla klienta.

public class CustomerBookingFacade {

    private static final double PRICE_PER_POWER_UNIT = 10.0;
    private static final String DEFAULT_CUSTOMER_TYPE = "DEFAULT";

    private final CustomerValidationService validationService = new CustomerValidationService();
    private final DiscountService discountService = new DiscountService();
    private final RentalHistoryService rentalHistoryService = new RentalHistoryService();
    private final LoyaltyPointsService loyaltyPointsService = new LoyaltyPointsService();
    private final RecommendationService recommendationService = new RecommendationService();

    public String prepareOffer(String customerId, Unicorn unicorn) {
        validationService.validateCustomerId(customerId);
        rentalHistoryService.getRentalHistory(unicorn.getId());
        double basePrice = calculateBasePrice(unicorn);
        double discountedPrice = discountService.applyDiscount(basePrice);
        loyaltyPointsService.calculatePoints(customerId);
        recommendationService.recommendExtras(DEFAULT_CUSTOMER_TYPE);
        String offerDescription = "Offer for customer " + customerId +
                " with unicorn " + unicorn.getName() +
                " | Base price: " + basePrice +
                " | Discounted price: " + discountedPrice;
        System.out.println("Preparing offer: " + offerDescription);
        return offerDescription;
    }

    private double calculateBasePrice(Unicorn unicorn) {
        return unicorn.getPowerLevel() * PRICE_PER_POWER_UNIT;
    }
}

//Koniec Tydzień 4, Wzorzec Facade
