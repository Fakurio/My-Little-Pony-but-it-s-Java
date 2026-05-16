package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis rekomendujący dodatki do wynajmu.

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Tydzien 7, zasada open-close sterowanie danymi
//rekomendacje dodatków nie sa zapisane w logice metody,
//ale z wynikaja z danych przechowywanych w mapie rekomendacji.

public class RecommendationService {

    private final Map<String, List<String>> recommendations = new HashMap<>();

    public RecommendationService() {
        recommendations.put("DEFAULT", List.of("Decoration", "Trainer"));
        recommendations.put("VIP", List.of("Decoration", "Trainer", "Golden Saddle"));
        recommendations.put("RAINBOW", List.of("Rainbow Sparkles", "Magic Trainer"));
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
