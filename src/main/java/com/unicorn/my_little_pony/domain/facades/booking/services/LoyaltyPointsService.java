package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis punktów lojalnościowych.

public class LoyaltyPointsService {
    private static final int DEFAULT_LOYALTY_POINTS = 100;

    public int calculatePoints(String customerId) {
        int points = DEFAULT_LOYALTY_POINTS;
        System.out.println("Points earned: " + points);
        return points;
    }
}
//Koniec Tydzień 4, Wzorzec Facade
