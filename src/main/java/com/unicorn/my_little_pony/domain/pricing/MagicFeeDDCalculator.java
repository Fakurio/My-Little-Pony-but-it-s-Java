package com.unicorn.my_little_pony.domain.pricing;

import java.util.HashMap;
import java.util.Map;

//Tydzień 7, OCP przez sterowanie danymi
public class MagicFeeDDCalculator {
    private final Map<String, Double> multipliers = new HashMap<>();

    public MagicFeeDDCalculator() {
        multipliers.put("Fire", 1.20);
        multipliers.put("Ice", 1.60);
        multipliers.put("Water", 1.40);
        multipliers.put("Lightning", 1.80);
    }

    // Klasa jest otwarta na rozbudowę -> dodajemy współczynniki opłaty bez zmiany kodu klasy
    public void addRule(String magicType, double multiplier) {
        multipliers.put(magicType, multiplier);
    }

    // Klasa jest zamknięta na modyfikacje -> metoda licząca jest uniwersalna i stała
    public double calculate(String magicType, double basePrice) {
        return basePrice * multipliers.getOrDefault(magicType, 1.0);
    }
}
// Koniec, Tydzień 7, OCP przez sterowanie danymi