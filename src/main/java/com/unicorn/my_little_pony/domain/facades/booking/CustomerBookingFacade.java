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

    private CustomerValidationService validationService = new CustomerValidationService();
    private DiscountService discountService = new DiscountService();
    private RentalHistoryService historyService = new RentalHistoryService();
    private LoyaltyPointsService loyaltyService = new LoyaltyPointsService();
    private RecommendationService recommendationService = new RecommendationService();

    public String prepareOffer(String customerId, Unicorn unicorn) {

        validationService.validate(customerId);

        historyService.checkHistory(customerId);

        double basePrice = unicorn.getPowerLevel() * PRICE_PER_POWER_UNIT;

        double discountedPrice = discountService.applyDiscount(basePrice);

        loyaltyService.calculatePoints(customerId);

        recommendationService.recommendExtras("DEFAULT");

        String offerDescription = "Offer for customer " + customerId +
                " with unicorn " + unicorn.getName() +
                " | Base price: " + basePrice +
                " | Discounted price: " + discountedPrice;

        System.out.println("Preparing offer: " + offerDescription);

        return offerDescription;
    }
}

//Koniec Tydzień 4, Wzorzec Facade