package com.unicorn.my_little_pony.domain.pricing;

import java.util.HashMap;
import java.util.Map;

//Tydzień 7, OCP przez sterowanie danymi
public class MagicFeeDDCalculator {
    private static final double FIRE_MULTIPLIER = 1.20;
    private static final double ICE_MULTIPLIER = 1.60;
    private static final double WATER_MULTIPLIER = 1.40;
    private static final double LIGHTNING_MULTIPLIER = 1.80;
    private static final double DEFAULT_MULTIPLIER = 1.0;

    private final Map<String, Double> multipliers = new HashMap<>();

    public MagicFeeDDCalculator() {
        multipliers.put("Fire", FIRE_MULTIPLIER);
        multipliers.put("Ice", ICE_MULTIPLIER);
        multipliers.put("Water", WATER_MULTIPLIER);
        multipliers.put("Lightning", LIGHTNING_MULTIPLIER);
    }

    // Klasa jest otwarta na rozbudowę -> dodajemy współczynniki opłaty bez zmiany kodu klasy
    public void addRule(String magicType, double multiplier) {
        multipliers.put(magicType, multiplier);
    }

    // Klasa jest zamknięta na modyfikacje -> metoda licząca jest uniwersalna i stała
    public double calculate(String magicType, double basePrice) {
        return basePrice * multipliers.getOrDefault(magicType, DEFAULT_MULTIPLIER);
    }
}
// Koniec, Tydzień 7, OCP przez sterowanie danymi