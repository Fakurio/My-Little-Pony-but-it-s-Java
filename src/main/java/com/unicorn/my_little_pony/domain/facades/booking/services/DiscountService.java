package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis naliczający rabaty.

public class DiscountService {

    private static final double STANDARD_DISCOUNT_MULTIPLIER = 0.9;

    public double applyDiscount(double price) {

        double discounted = price * STANDARD_DISCOUNT_MULTIPLIER;

        System.out.println("Discount applied: " + discounted);

        return discounted;
    }
}
//Koniec Tydzień 4, Wzorzec Facade