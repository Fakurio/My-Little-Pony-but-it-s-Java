package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis rekomendujący dodatki do wynajmu.

import java.util.ArrayList;
import java.util.List;

import java.util.*;

//Tydzien 7, zasada open-close sterowanie danymi
//rekomendacje dodatków nie sa zapisane w logice metody,
//ale z wynikaja z danych przechowywanych w mapie rekomendacji.

public class RecommendationService {

    private final Map<String, List<String>> recommendations = new HashMap<>();

    public RecommendationService() {
        recommendations.put("DEFAULT", Arrays.asList("Decoration", "Trainer"));
        recommendations.put("VIP", Arrays.asList("Decoration", "Trainer", "Golden Saddle"));
        recommendations.put("RAINBOW", Arrays.asList("Rainbow Sparkles", "Magic Trainer"));
    }

    public void addRule(String customerType, List<String> extras) {
        recommendations.put(customerType, extras);
    }

    public List<String> recommendExtras(String customerType) {

        List<String> result =
                recommendations.getOrDefault(customerType, recommendations.get("DEFAULT"));

        System.out.println("Recommended extras: " + result);

        return result;
    }
}
//Koniec Tydzien 7
//Koniec Tydzień 4, Wzorzec Facade