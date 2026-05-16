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
        collectCustomerContext(customerId, unicorn);
        OfferPrice offerPrice = calculateOfferPrice(unicorn);
        String offerDescription = formatOffer(customerId, unicorn, offerPrice);
        publishOffer(offerDescription);
        return offerDescription;
    }

    private void collectCustomerContext(String customerId, Unicorn unicorn) {
        rentalHistoryService.getRentalHistory(unicorn.getId());
        loyaltyPointsService.calculatePoints(customerId);
        recommendationService.recommendExtras(DEFAULT_CUSTOMER_TYPE);
    }

    private OfferPrice calculateOfferPrice(Unicorn unicorn) {
        double basePrice = calculateBasePrice(unicorn);
        double discountedPrice = discountService.applyDiscount(basePrice);
        return new OfferPrice(basePrice, discountedPrice);
    }

    private double calculateBasePrice(Unicorn unicorn) {
        return unicorn.getPowerLevel() * PRICE_PER_POWER_UNIT;
    }

    private String formatOffer(String customerId, Unicorn unicorn, OfferPrice offerPrice) {
        return "Offer for customer " + customerId +
                " with unicorn " + unicorn.getName() +
                " | Base price: " + offerPrice.basePrice() +
                " | Discounted price: " + offerPrice.discountedPrice();
    }

    private void publishOffer(String offerDescription) {
        System.out.println("Preparing offer: " + offerDescription);
    }

    private record OfferPrice(double basePrice, double discountedPrice) {
    }
}

//Koniec Tydzień 4, Wzorzec Facade
