package com.unicorn.my_little_pony.util;

import java.util.concurrent.atomic.AtomicLong;

//Tydzień 2, Wzorzec Singleton 2 (Thread-safe synchronized)
// identyfikatory obiektów (Unicorn, Customer, Rental) muszą być unikalne w obrębie całej aplikacji.
// zapewnia istnienie jednego, wspólnego źródła generowania ID, co eliminuje niespójności danych.
public final class IdGenerator {
    private static IdGenerator instance;

    private final AtomicLong unicornSequence = new AtomicLong(1);
    private final AtomicLong customerSequence = new AtomicLong(1);
    private final AtomicLong rentalSequence = new AtomicLong(1);

    private IdGenerator() {}

    public static synchronized IdGenerator getInstance() {
        if (instance == null){
            instance = new IdGenerator();
        }
        return instance;
    }

    public String nextUnicornId() {
        return "U" + unicornSequence.getAndIncrement();
    }

    public String nextCustomerId() {
        return "C" + customerSequence.getAndIncrement();
    }

    public String nextRentalId() {
        return "R" + rentalSequence.getAndIncrement();
    }
}
//Koniec, Tydzień 2, Wzorzec Singleton 2