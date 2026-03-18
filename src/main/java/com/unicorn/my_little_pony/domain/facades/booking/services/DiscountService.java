package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis naliczający rabaty.

public class DiscountService {

    public double applyDiscount(double price) {

        double discounted = price * 0.9;

        System.out.println("Discount applied: " + discounted);

        return discounted;
    }
}
//Koniec Tydzień 4, Wzorzec Facade